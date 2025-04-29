package me.fit.Scheduler;


import io.quarkus.scheduler.Scheduled;
import me.fit.model.client.TimeResponse;
import me.fit.restclient.TimeClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

public class SchedulerUtil {

    @RestClient
    TimeClient ipClient;

    @RestClient
    TimeClient timeClient;

    @Scheduled(every = "1s")
    void getTime(){

        TimeResponse timeResponse = timeClient.getTime("Europe/Amsterdam");
        System.out.println(timeResponse);
    }



//    public void getTimeByIp(){
//        String s = ipClient.getIp();
//        timeClient.getIp(String s);
//    }
}
