package com.example.multipartFileTest;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@NoArgsConstructor
public class WriteConsole {

   @Value("${greeting.salutation}")
   private String greetingSalutation;
	
   public void writeConsole(){
      System.out.println(greetingSalutation);
   }
	
}
