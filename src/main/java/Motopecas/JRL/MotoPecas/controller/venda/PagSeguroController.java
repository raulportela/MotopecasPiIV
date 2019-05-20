/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.controller.venda;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.uol.pagseguro.domain.*;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import com.sun.istack.internal.logging.Logger;
import java.util.logging.Level;
import org.aspectj.apache.bcel.classfile.Utility;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Luana
 */

@Controller
@Scope(value = "request")

public class PagSeguroController{
    
    private final String Email ="jeferson_nls@hotmail.com";
    private final String TOKEN ="78385a79-b9df-4b03-8185-8ba926c466af066022dc4358987d41777c99d34d059edace-8d5e-4638-8569-fa36e3f573d7";
    
    @RequestMapping(value ="/pagseguro-criarpagmento",produces = Utility.DEFAULT_PRODUCES_VALUE)
    public @ResponseBody
    String criarPagamento(){
        try {
            PaymentRequest request = new PaymentRequest();
            request.setReference(TOKEN);
            request.setCurrency(Currency.BRL);
            request.setSender();
            request.setShipping(shipping);
            request.addItem(item);
            request.setNotificationURL(Email);
            request.setRedirectURL(Email);
            
            return request.register(credentials);
        } catch (PagSeguroServiceException ex) {
            Logger.getLogger(PagSeguroController.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
            
        }
        
    }
    
    
    

   
    
}
