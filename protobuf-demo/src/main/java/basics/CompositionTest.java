package basics;

import com.proto.grpc.models.BodyStyle;
import com.proto.grpc.models.Car;
import com.proto.grpc.models.Owner;

import java.util.ArrayList;
import java.util.List;

public class CompositionTest {
    public static void main(String[] args) {


        Car car = Car.newBuilder().setName("baleno")
                .setModel("delta")
                .setYear(2018)
                .build();
        Car car2 = Car.newBuilder().setName("suv700")
                .setModel("delta")
                .setYear(2024)
                .setStyle(BodyStyle.suv)
                .build();
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car2);

        Owner priyanshu = Owner.newBuilder()
                .setName("priyanshu")
                .addAllCars(cars)
                .build();
        System.out.println(priyanshu);
        System.out.println(car);
    }
}
