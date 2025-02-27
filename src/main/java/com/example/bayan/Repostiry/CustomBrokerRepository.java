package com.example.bayan.Repostiry;

import com.example.bayan.Model.Border;
import com.example.bayan.Model.CustomsBroker;
import com.example.bayan.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomBrokerRepository extends JpaRepository<CustomsBroker,Integer> {


    CustomsBroker findCustomsBrokerById(Integer id);


    CustomsBroker findCustomsBrokerByLicenseNumber(String licenseNumber);

    @Query("SELECT DISTINCT c FROM CustomsBroker c JOIN c.borders b WHERE b.name = :borderName")
    List<CustomsBroker> findAllByBorderName(@Param("borderName") String borderName);


//    List<CustomsBroker> getCustomsBrokerByCustomerName(String customerName);

    @Query("SELECT c FROM CustomsBroker c WHERE c.user.fullName = :name")
    List<CustomsBroker> findCustomsBrokerByUserFullName(@Param("name") String name);

    List<CustomsBroker>getCustomsBrokerByLicenseType(String licenseType);

    List<CustomsBroker> findAllByIsActiveFalse();

    CustomsBroker findCustomsBrokerByUser(MyUser user);
}
