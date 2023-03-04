package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeServiceImpl;


    @PostMapping("/signup")

    public ResponseEntity<String> signUp(@RequestBody Employee employee){
        employeeServiceImpl.signUp(employee);
        return ResponseEntity.ok("Sign Up Done Succesfully");

    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")

    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId,@PathVariable String empPassword){
       return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
    }

    @GetMapping("/getdatabyid/{empId}")

    public ResponseEntity<Employee> getDataById(@PathVariable int empId){

        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @GetMapping("getalldata")

    public ResponseEntity <List<Employee>> getAllData(){

        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @GetMapping("/getdatabyname/{empName}")

    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName){
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));

    }

    @PutMapping("/updatedata/{empId}")

    public ResponseEntity<String> updateData(@PathVariable int empId,@RequestBody Employee employee){

        employeeServiceImpl.updateData(empId,employee);
        return ResponseEntity.ok("Updated");
    }
    @DeleteMapping("/deletebyid/{empId}")

    public ResponseEntity<String> deleteDataById(@PathVariable int empId){

        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Data Daleted Sussesfully");
    }

    @DeleteMapping("deletealldata")
    public ResponseEntity<String> deletAllData(){

        employeeServiceImpl.deleteAllData();
     return ResponseEntity.ok("All Data Deleted Succesfully");
    }

    @GetMapping("/getdatabycontactnumber/{empContactNumber}")
    public ResponseEntity <List<Employee>> getDataByContactNumber(@PathVariable long empContactNumber){

        return ResponseEntity.ok(employeeServiceImpl.getDataByContactNumber(empContactNumber));
    }

}
