package repository;

import repository.custom.impl.CustomerRepositoryImpl;
import repository.custom.impl.ItemRepositoryImpl;
import repository.custom.impl.OrderRepositoryImpl;
import service.SuperService;
import service.custom.impl.CustomerServiceImpl;
import service.custom.impl.ItemServiceImpl;
import service.custom.impl.OrderServiceImpl;
import utill.RepositoryType;
import utill.ServiceType;

public class RepositoryFactory {
    public static RepositoryFactory instance;
    private RepositoryFactory(){

    }

    public static RepositoryFactory getInstance(){
        return instance==null?instance=new RepositoryFactory():instance;
    }

    public <T extends SuperRepository>T getRepositoryType(RepositoryType type){
        switch(type){
            case CUSTOMER:new CustomerRepositoryImpl();
            case ITEM:new ItemRepositoryImpl();
            case ORDER:new OrderRepositoryImpl();
        }
        return null;
    }
}
