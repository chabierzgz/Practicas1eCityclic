package com.ecityclic.practicas1eCityclic;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {
	


    @Override
    public void run(ApplicationArguments args) throws Exception {

	}



	public boolean someLibraryMethod() {
		return true;
	}
}
