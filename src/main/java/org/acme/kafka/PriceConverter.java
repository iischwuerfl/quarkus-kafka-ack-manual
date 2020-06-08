package org.acme.kafka;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

/**
 * A bean consuming data from the "prices" Kafka topic and applying some conversion.
 * The result is pushed to the "my-data-stream" stream which is an in-memory stream.
 */
@ApplicationScoped
public class PriceConverter {

    int counter = 0;

    @Incoming("prices")
    @Acknowledgment(value = Acknowledgment.Strategy.MANUAL)
    public CompletionStage<Void> receive(Message<String> message) {
        counter++;
        System.out.println("message with count " + counter + " processed.");
        return CompletableFuture.runAsync(() -> {
            //do nothing
        });
    }

}
