package br.com.alura.ecommerce;

import java.util.UUID;

public class NewOrderMain {

    public static void main(String[] args) throws Exception {
        try(var dispatcher = new KafkaDispatcher()) {
            for (var i = 0; i < 10; i++) {
                var key = UUID.randomUUID().toString();
                var order = "123123,2132,123454";
                dispatcher.send("ECOMMERCE_NEW_ORDER", key, order);

                var email = "Thank you for your order! We are processing your order";
                dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
            }
        }
    }
}
