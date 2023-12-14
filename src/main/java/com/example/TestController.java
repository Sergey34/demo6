package com.example;

import io.quarkus.cache.CacheKey;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

import java.util.Map;

@ApplicationScoped
@Path("/test")
public class TestController {
    @GET
    @Path("/{keyElement1}/{keyElement2}/{keyElement3}")
    @CacheResult(cacheName = "expensiveResourceCache")
    public String foo(
        @PathParam("keyElement1") @CacheKey String keyElement1,
        @PathParam("keyElement2") @CacheKey String keyElement2,
        @PathParam("keyElement3") @CacheKey String keyElement3,
        @QueryParam("foo") String foo
    ) {
        System.out.println("load");
        return Map.of(keyElement1,keyElement2,keyElement3, foo).toString();
    }
}
