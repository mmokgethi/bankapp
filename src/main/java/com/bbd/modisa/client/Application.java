package com.bbd.modisa.client;

import com.bbd.modisa.service.AccountServiceImpl;
import com.bbd.modisa.service.BankingServiceImpl;
import com.sun.net.httpserver.HttpServer;

import javax.ws.rs.ApplicationPath;
import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

@ApplicationPath("/")
public class Application extends javax.ws.rs.core.Application {

    public static void main(String[] args) throws IOException {
        final HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getByName("0.0.0.0"),
                8080), 16);

        final Endpoint accountServiceEndpoint = Endpoint.create(new AccountServiceImpl());
        accountServiceEndpoint.publish(httpServer.createContext("/account"));

        final Endpoint bankingServiceEndPoint = Endpoint.create(new BankingServiceImpl());
        bankingServiceEndPoint.publish(httpServer.createContext("/bank"));

        httpServer.start();

        //Endpoint.publish("hhtp://localhost:8082/testSop", new AccountServiceImpl());
    }
}
