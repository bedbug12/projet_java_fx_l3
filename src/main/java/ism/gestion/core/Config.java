package ism.gestion.core;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Config {

    private static String file="src/main/resources/ism/gestion/parametre.json";
    
   
  
    //create JsonNode
    public static JsonNode readJsonFile() throws StreamReadException, DatabindException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(file);
        JsonNode jsonNode = objectMapper.readValue(jsonFile, JsonNode.class);
        return jsonNode;
    }
    public static void writeJsonFile() throws StreamReadException, DatabindException, IOException{
        Etudiant etudiant=new Etudiant(getSeqEtudiant()+1);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        File jsonFile = new File(file);
        writer.writeValue(jsonFile, etudiant);
        
    }
    
    

    

     public static int getSeqEtudiant() throws StreamReadException, DatabindException, IOException{
        JsonNode jsonNode=readJsonFile();
        JsonNode sequenceNode = jsonNode.get("num");
        
        return sequenceNode.asInt();
     }
     public static String getPrefEtudiant() throws StreamReadException, DatabindException, IOException{
        JsonNode jsonNode=readJsonFile();
        JsonNode prefixNode = jsonNode.get("prefix");
        
        return prefixNode.asText();  
     }


}
