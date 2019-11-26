package com.limpid.test;

import com.limpid.service.SpiService;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName TestSpi
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-11-26 18:21
 */
public class TestSpi {

    public static void main(String[] args) {
        ServiceLoader<SpiService> loader1 = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> loader2 = Service.providers(SpiService.class);

        while(loader2.hasNext()) {
            SpiService next = loader2.next();
            System.out.println(next.excute());
        }
        
        System.out.println("====================");

        Iterator<SpiService> iterator = loader1.iterator();
        while(iterator.hasNext()) {
            SpiService next = iterator.next();
            System.out.println(next.excute());
        }

    }

}
