/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author jvm
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(entity.service.AddressFacadeREST.class);
        resources.add(entity.service.AnnouncementFacadeREST.class);
        resources.add(entity.service.ChildFacadeREST.class);
        resources.add(entity.service.EmailFacadeREST.class);
        resources.add(entity.service.MessageAccsessFacadeREST.class);
        resources.add(entity.service.MessageFacadeREST.class);
        resources.add(entity.service.PersonFacadeREST.class);
        resources.add(entity.service.SecurityGroupFacadeREST.class);
        resources.add(entity.service.StatusFacadeREST.class);
        resources.add(entity.service.TelefoneFacadeREST.class);
        resources.add(entity.service.UserFacadeREST.class);
        resources.add(entity.service.UsersInSecurityGroupFacadeREST.class);
    }
    
}
