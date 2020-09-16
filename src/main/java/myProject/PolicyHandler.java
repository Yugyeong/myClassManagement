package myProject;

import myProject.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }
    
    @Autowired
    MyClassRepository myClassRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceled_StudentCancel(@Payload Canceled canceled){

        if(canceled.isMe()){
            System.out.println("##### listener StudentCancel : " + canceled.toJson());
            
            MyClass myClass = new MyClass();
            
            myClass.setClassName(canceled.getClassName());
            myClass.setStatus("Canceled");
            myClass.setStudentId(canceled.getStudentId());
            myClass.setStudentName(canceled.getStudentName());

			myClassRepository.save(myClass);
            
        }
    }
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSigned_StudentSign(@Payload Signed signed){

        if(signed.isMe()){
            System.out.println("##### listener StudentSigned : " + signed.toJson());
            
            MyClass myClass = new MyClass();
            
            myClass.setClassName(signed.getClassName());
            myClass.setStatus("Signed");
            myClass.setStudentId(signed.getStudentId());
            myClass.setStudentName(signed.getStudentName());

			myClassRepository.save(myClass);
            
        }
    }

}
