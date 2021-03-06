package MS_B.Services;

import MS_B.Model.ResponseModel;
import MS_B.Model.SalesRecord;
import MS_B.Model.StaffB;
import MS_B.Repositories.SalesRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

import static MS_B.Configurations.config.RESPONSE_CODE_1000;
import static MS_B.Configurations.config.RESPONSE_CODE_1999;



@Service
@Slf4j
public class SalesRecordService {
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private SalesRecordRepository salesRecordRepository;

    HttpHeaders httpHeaders;

    public ResponseEntity getSalesRec(StaffB staff){
        ResponseModel res = new ResponseModel<>();
        res.setStatus(RESPONSE_CODE_1999);
        if(salesRecordRepository.checkExist(staff.getEID())!=null){
            log.info("User already exist.");
            return null;
        }
        res.setStatus(RESPONSE_CODE_1000);
        List<SalesRecord> salesRecords = salesRecordRepository.getSalesRecord(staff.getFName());
        res.setDataObj(salesRecords);
        return new ResponseEntity<>(res,httpHeaders, HttpStatus.OK);
    }
}