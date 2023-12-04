package basics;

import basics.json.JPerson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.pro.grpc.models.Person;

public class BinarySizeTest {

    public static void main(String[] args) throws JsonProcessingException {
        JPerson jPerson = new JPerson("priyanshu", 33);
        ObjectMapper mapper = new ObjectMapper();
        byte[] bytes = mapper.writeValueAsBytes(jPerson);

        Person person = Person.newBuilder().setAge(33)
                .setName("priyanshu")
                .build();


        byte[] byteArray = person.toByteArray();

        System.out.println( "lenth of jsonbynary: "+ bytes.length +" length of probuf:"+byteArray.length);
    }
}
