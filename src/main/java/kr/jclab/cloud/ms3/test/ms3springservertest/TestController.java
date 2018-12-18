package kr.jclab.cloud.ms3.test.ms3springservertest;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import kr.jclab.ms3.client.MS3ClientBuilder;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/test")
@Controller
public class TestController {

    @RequestMapping(path = "/list")
    public ResponseEntity<Object> list() {
        AmazonS3 s3 = MS3ClientBuilder.standard().serverUrl("http://localhost:8080/ms3/").build();
        Object response = s3.listObjects("test");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(path = "/test1")
    public ResponseEntity<InputStreamResource> test1() {
        AmazonS3 s3 = MS3ClientBuilder.standard().serverUrl("http://localhost:8080/ms3/").build();
        S3Object response = s3.getObject("test", "bbbb");
        System.err.println(response.getObjectMetadata());
        return new ResponseEntity<>(new InputStreamResource(response.getObjectContent()), HttpStatus.OK);
    }

}
