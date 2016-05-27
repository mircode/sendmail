package com.sendmail.override;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.util.ClassUtils;
import org.apache.velocity.util.ExceptionUtils;

import com.sendmail.conf.Configure;

public class FileResourceLoader extends ClasspathResourceLoader{
	
    public InputStream getResourceStream( String name )
        throws ResourceNotFoundException
    {
        InputStream result = null;

        if (StringUtils.isEmpty(name))
        {
            throw new ResourceNotFoundException ("No template name provided");
        }

        try
        {
            result = this.getResourceAsStream(name);
        }
        catch( Exception fnfe )
        {
            throw (ResourceNotFoundException) ExceptionUtils.createWithCause(ResourceNotFoundException.class, "problem with template: " + name, fnfe );
        }

        if (result == null)
        {
             String msg = "FileResourceLoader Error: cannot find resource " +
              name;

             throw new ResourceNotFoundException( msg );
        }

        return result;
    }
  
    @SuppressWarnings("resource")
	public  InputStream getResourceAsStream(String name) throws FileNotFoundException
    {
        InputStream result = null;
        File templateFile=new File(Configure.getTemplateDir()+name);
        
        if(templateFile.exists()){
        	result=new FileInputStream(templateFile);	
        }else{
        	result=ClassUtils.getResourceAsStream( getClass(), name );
        }
        
        return result;
    }

}
