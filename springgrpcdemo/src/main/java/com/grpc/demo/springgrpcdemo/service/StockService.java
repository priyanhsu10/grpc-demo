package com.grpc.demo.springgrpcdemo.service;

import com.pro.grpc.models.ReactorStockServiceGrpc;
import com.pro.grpc.models.StockPrice;
import com.pro.grpc.models.StockRequest;
import net.devh.boot.grpc.server.service.GrpcService;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;

@GrpcService
public class StockService extends ReactorStockServiceGrpc.StockServiceImplBase{
    @Override
    public Flux<StockPrice> getData(StockRequest request) {
        Random random=new Random();

         int count= request.getCount();

        return Flux.range(1,count)
                   .delayElements(Duration.ofSeconds(1))
                   .map(x->StockPrice.newBuilder().setStockName("stoke-"+x)
                           .setStockPrice(random.nextFloat(400,500)).build());


    }


}
