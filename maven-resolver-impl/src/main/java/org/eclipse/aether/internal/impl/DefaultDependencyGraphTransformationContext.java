package org.eclipse.aether.internal.impl;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.collection.DependencyGraphTransformationContext;

/**
 */
class DefaultDependencyGraphTransformationContext
    implements DependencyGraphTransformationContext
{

    private final RepositorySystemSession session;

    private final Map<Object, Object> map;

    public DefaultDependencyGraphTransformationContext( RepositorySystemSession session )
    {
        this.session = session;
        this.map = new HashMap<Object, Object>();
    }

    public RepositorySystemSession getSession()
    {
        return session;
    }

    public Object get( Object key )
    {
        return map.get( Objects.requireNonNull( key, "key cannot be null" ) );
    }

    public Object put( Object key, Object value )
    {
        Objects.requireNonNull( key, "key cannot be null" );
        if ( value != null )
        {
            return map.put( key, value );
        }
        else
        {
            return map.remove( key );
        }
    }

    @Override
    public String toString()
    {
        return String.valueOf( map );
    }

}
