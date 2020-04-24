package com.lisz;

public interface IMessageSender {
    public void send(String topic, String key, String value);
}
