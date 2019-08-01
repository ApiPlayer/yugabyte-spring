package com.yugabyte.springdemo.model.util;

import com.yugabyte.springdemo.model.util.JsonBinarySqlTypeDescriptor;
import com.yugabyte.springdemo.model.util.JsonTypeDescriptor;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

public class JsonBinaryType extends AbstractSingleColumnStandardBasicType<Object>
    implements DynamicParameterizedType
{
    public JsonBinaryType() {
        super(JsonBinarySqlTypeDescriptor.INSTANCE,
            new JsonTypeDescriptor());

    }

    public String getName() {
        return "jsonb";
    }

    @Override
    public void setParameterValues(Properties properties)
    {
        ((JsonTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(properties);
    }
}
