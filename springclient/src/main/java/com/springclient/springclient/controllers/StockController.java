package com.springclient.springclient.controllers;

import com.pro.grpc.models.ReactorStockServiceGrpc;
import com.pro.grpc.models.StockPrice;
import com.pro.grpc.models.StockRequest;
import com.pro.grpc.models.StockServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/stocks")
public class StockController {

   @GrpcClient("grpc-stock-service")
    ReactorStockServiceGrpc.ReactorStockServiceStub stockServiceStub;
    @GetMapping("/{count}")
    public Flux<Stocks> getData(@PathVariable int count){
        return stockServiceStub.getData(StockRequest.newBuilder().setCount(count).build())
              .map(x->new Stocks(x.getStockName(),x.getStockPrice()));
    }

}
