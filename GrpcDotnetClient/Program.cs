// See https://aka.ms/new-console-template for more information
using Grpc.Net.Client;
using dotnetclient;
using Grpc.Core;


using var channel = GrpcChannel.ForAddress("http://localhost:9000");
var client = new StockService.StockServiceClient(channel);

var stream = client.getData(new StockRequest() { Count = 10 });
await foreach (StockPrice stok in stream.ResponseStream.ReadAllAsync<StockPrice>())
{

    Console.WriteLine($"stock name: {stok.StockName} stock price : {stok.StockPrice_}");
}

