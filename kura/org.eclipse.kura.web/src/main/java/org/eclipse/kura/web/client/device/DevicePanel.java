/*******************************************************************************
 * Copyright (c) 2011, 2016 Eurotech and/or its affiliates
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech
 *******************************************************************************/
package org.eclipse.kura.web.client.device;

import org.eclipse.kura.web.client.messages.Messages;
import org.eclipse.kura.web.shared.model.GwtSession;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;

public class DevicePanel extends LayoutContainer 
{
	private static final Messages MSGS = GWT.create(Messages.class);

    @SuppressWarnings("unused")
	private boolean                m_initialized;
	private GwtSession             m_currentSession;

	private DeviceTabs      m_deviceConfigTabs; 
			
    public DevicePanel(GwtSession currentSession) {
    	m_currentSession  = currentSession;
    	m_initialized     = false;
    }

    protected void onRender(Element parent, int index) {
        
        super.onRender(parent, index);
        setId("device-panel-wrapper");
        
        m_deviceConfigTabs = new DeviceTabs(m_currentSession);
        
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        setBorders(true);

        //
        // north
        BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH, 10);  
        northData.setMargins(new Margins(10, 25, 5, 25));
        Label intro = new Label(MSGS.deviceIntro());
        intro.setId("device-label");
        add(intro, northData);

        //
        // center
        BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);  
        centerData.setMargins(new Margins(10, 25, 25, 25));          
        add(m_deviceConfigTabs, centerData);
        addStyleName("device-panel-wrapper");
                
        m_initialized = true;
    }    
}
