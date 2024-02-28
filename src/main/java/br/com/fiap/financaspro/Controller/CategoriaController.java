package br.com.fiap.financaspro.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoriaController {
    @RequestMapping(method = RequestMapping.GET, path = "/categoria", produces = "application/json")
    @ResponseBody
    public String index(){
    return """
          [
            {
                "id":1,
                "nome":"Alimentação",
                "icone":"fast-food"
            }
            {
               "id":2,
                "nome":"Educação",
                "icone":"book"
            }
            ]      
             """;

}
