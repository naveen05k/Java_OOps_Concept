package ucp.broadcast.ucpbroadcast.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ucp.broadcast.ucpbroadcast.entity.Broadcast;
import ucp.broadcast.ucpbroadcast.entity.BroadcastContact;
import ucp.broadcast.ucpbroadcast.entity.BroadcastContactPK;
import ucp.broadcast.ucpbroadcast.entity.UcpTemplate;
import ucp.broadcast.ucpbroadcast.repository.BroadcastContactRepository;
import ucp.broadcast.ucpbroadcast.repository.BroadcastRepository;
import ucp.broadcast.ucpbroadcast.repository.CompanyMasterRepository;
import ucp.broadcast.ucpbroadcast.repository.Template;
import ucp.broadcast.ucpbroadcast.request.BroadcastContactModal;
import ucp.broadcast.ucpbroadcast.request.BroadcastRequestModal;
import ucp.broadcast.ucpbroadcast.response.ResponseModel;
import ucp.broadcast.ucpbroadcast.service.Util;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class BroadCastController {

@Autowired
private BroadcastContactRepository contactRepo;

@Autowired
private CompanyMasterRepository companyMasterRepo;

@Autowired
private BroadcastRepository broadcastRepo;

@Autowired
private Template templateRepo;

@Autowired
Util util;

@PostMapping("/saveBroadcast")
public ResponseEntity<ResponseModel> saveBroadcast(@RequestBody BroadcastRequestModal req) {
ResponseModel retModel = new ResponseModel();
try {
Broadcast reg = new Broadcast();
reg.setTemplateId(req.getTemplateId());
reg.setCompCode(req.getCompCode());
SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
String broadcastName = "untitle" + String.valueOf(df.format(new Date()));
reg.setBroadcastName(broadcastName);
reg.setCreatedBy("");
reg.setCreatedOn(new Date());
reg.setUpdatedBy("");
reg.setUpdatedOn(new Date());
reg.setStatus("A");
reg.setImageUrl(req.getImageUrl());

broadcastRepo.saveAndFlush(reg);
retModel.setStatus(true);
retModel.setMessage("Saved successfully");
return ResponseEntity.ok(retModel);

} catch (Exception e) {
retModel.setStatus(false);
retModel.setMessage(e.getMessage());
}
return ResponseEntity.ok(retModel);
}

@PostMapping("/updateBroadcast")
public ResponseEntity<ResponseModel> updateBroadcast(@RequestBody BroadcastRequestModal req) {
ResponseModel retModel = new ResponseModel();
try {
Broadcast reg = broadcastRepo.getById(req.getBroadcastId());
if (null != reg) {
reg.setBroadcastId(req.getBroadcastId());
reg.setTemplateId(req.getTemplateId());
SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
String broadcastName = req.getBroadcastName() + String.valueOf(df.format(new Date()));
reg.setBroadcastName(broadcastName);
reg.setCreatedBy("");
reg.setCreatedOn(new Date());
reg.setUpdatedBy("");
reg.setUpdatedOn(new Date());
reg.setStatus(req.getStatus());
reg.setImageUrl(req.getImageUrl());
broadcastRepo.saveAndFlush(reg);
retModel.setStatus(true);
retModel.setMessage("Updated successfully");
} else {
retModel.setStatus(false);
retModel.setMessage("No Data Found");
}
return ResponseEntity.ok(retModel);

} catch (Exception e) {
retModel.setStatus(false);
retModel.setMessage(e.getMessage());
}
return ResponseEntity.ok(retModel);
}

@GetMapping("/getBroadcast")
public ResponseEntity<ResponseModel> getBroadcast() {
ResponseModel retModel = new ResponseModel();
List<BroadcastRequestModal> objList = new ArrayList<BroadcastRequestModal>();
try {
List<Broadcast> list = broadcastRepo.findAll();
for (Broadcast broadcast : list) {
BroadcastRequestModal reg = new BroadcastRequestModal();
reg.setBroadcastId(broadcast.getBroadcastId());
reg.setTemplateId(broadcast.getTemplateId());
UcpTemplate template = templateRepo.findByIdTemplateId(broadcast.getTemplateId());
reg.setTemplateName(null != template ? template.getTemplateName() : "");
reg.setBroadcastName(broadcast.getBroadcastName());
reg.setStatus(broadcast.getStatus());
reg.setCompCode(broadcast.getCompCode());
reg.setCompName(companyMasterRepo.getById(broadcast.getCompCode()).getCompName());
reg.setImageUrl(broadcast.getImageUrl());
objList.add(reg);
}
retModel.setStatus(true);
retModel.setData(objList);
return ResponseEntity.ok(retModel);
} catch (Exception e) {
retModel.setStatus(false);
retModel.setMessage(e.getMessage());
}
return ResponseEntity.ok(retModel);
}

@PostMapping("/deleteBroadcast")
public ResponseEntity<ResponseModel> deleteBroadcast(Integer broadCastId) {
ResponseModel retModel = new ResponseModel();
try {
Broadcast reg = broadcastRepo.getById(broadCastId);
if (null != reg) {
reg.setStatus("X");
broadcastRepo.saveAndFlush(reg);
retModel.setStatus(true);
retModel.setMessage("Deleted successfully");
} else {
retModel.setStatus(false);
retModel.setMessage("No Data Found");
}
return ResponseEntity.ok(retModel);

} catch (Exception e) {
retModel.setStatus(false);
retModel.setMessage(e.getMessage());
}
return ResponseEntity.ok(retModel);
}

@PostMapping("/saveBroadcastContact")
public ResponseEntity<ResponseModel> saveBroadcastContact(@RequestBody BroadcastContactModal req) {
ResponseModel retModel = new ResponseModel();
try {
BroadcastContact reg = new BroadcastContact();
BroadcastContactPK pk = new BroadcastContactPK();
pk.setBroadcastId(req.getBroadcastId());
pk.setCompCode(req.getCompCode());
reg.setId(pk);
reg.setContactMobileno(req.getContactMobileNo());
reg.setContactName(req.getContactName());
reg.setCreatedBy("");
reg.setCreatedOn(new Date());
reg.setUpdatedBy("");
reg.setUpdatedOn(new Date());
reg.setEligibility(req.getEligibility());
reg.setStatus("A");
contactRepo.saveAndFlush(reg);
retModel.setStatus(true);
retModel.setMessage("Saved successfully");
return ResponseEntity.ok(retModel);

} catch (Exception e) {
retModel.setStatus(false);
retModel.setMessage(e.getMessage());
}
return ResponseEntity.ok(retModel);
}

@PostMapping("/updateBroadcastContact")
public ResponseEntity<ResponseModel> updateBroadcastContact(@RequestBody BroadcastContactModal req) {
ResponseModel retModel = new ResponseModel();
try {
BroadcastContactPK pk = new BroadcastContactPK();
pk.setCompCode(req.getCompCode());
pk.setBroadcastId(req.getBroadcastId());
BroadcastContact reg = contactRepo.getById(pk);
if (null != reg) {
reg.setContactMobileno(req.getContactMobileNo());
reg.setContactName(req.getContactName());
reg.setCreatedBy("");
reg.setCreatedOn(new Date());
reg.setUpdatedBy("");
reg.setUpdatedOn(new Date());
reg.setEligibility(req.getEligibility());
reg.setStatus(req.getStatus());
contactRepo.saveAndFlush(reg);
retModel.setStatus(true);
retModel.setMessage("Updated successfully");
} else {
retModel.setStatus(false);
retModel.setMessage("No Data Found");
}
return ResponseEntity.ok(retModel);

} catch (Exception e) {
retModel.setStatus(false);
retModel.setMessage(e.getMessage());
}
return ResponseEntity.ok(retModel);
}

@GetMapping("/getBroadcastContact")
public ResponseEntity<ResponseModel> getBroadcastContact() {
ResponseModel retModel = new ResponseModel();
List<BroadcastContactModal> objList = new ArrayList<BroadcastContactModal>();
try {
List<BroadcastContact> list = contactRepo.findAll();
for (BroadcastContact broadcast : list) {
BroadcastContactModal reg = new BroadcastContactModal();
reg.setBroadcastId(broadcast.getId().getBroadcastId());
reg.setCompCode(broadcast.getId().getCompCode());
reg.setCompName(companyMasterRepo.getById(broadcast.getId().getCompCode()).getCompName());
reg.setContactMobileNo(broadcast.getContactMobileno());
reg.setContactName(broadcast.getContactName());
reg.setEligibility(broadcast.getEligibility());
reg.setStatus(broadcast.getStatus());
objList.add(reg);
}
retModel.setStatus(true);
retModel.setData(objList);
return ResponseEntity.ok(retModel);
} catch (Exception e) {
retModel.setStatus(false);
retModel.setMessage(e.getMessage());
}
return ResponseEntity.ok(retModel);
}

}
