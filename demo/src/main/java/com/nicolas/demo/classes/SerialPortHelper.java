package com.nicolas.demo.classes;

import java.util.ArrayList;
import java.util.List;
import com.fazecast.jSerialComm.*;

public class SerialPortHelper {
    public static List<String> getCommPorts() {
        SerialPort[] ports = SerialPort.getCommPorts();
        List<String> list = new ArrayList<>();
        for (SerialPort port : ports) {
//            System.out.println(port.getSystemPortName());
            list.add(port.getSystemPortName());
        }
//        System.out.println("List of serial port is : "+list);
        return list;
    }
}
