﻿package manywho.flow.sdk.draw.elements.ui;

import java.io.Serializable;

import org.json.JSONObject;

/*!

Copyright 2013 ManyWho, Inc.

Licensed under the ManyWho License, Version 1.0 (the "License"); you may not use this
file except in compliance with the License.

You may obtain a copy of the License at: http://manywho.com/sharedsource

Unless required by applicable law or agreed to in writing, software distributed under
the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied. See the License for the specific language governing
permissions and limitations under the License.

*/

public class PageContainerAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privateid;
	public final String getId()
	{
		return privateid;
	}
	public final void setId(String value)
	{
		privateid = value;
	}

	private String privatecontainerType;
	public final String getContainerType()
	{
		return privatecontainerType;
	}
	public final void setContainerType(String value)
	{
		privatecontainerType = value;
	}

	private String privatedeveloperName;
	public final String getDeveloperName()
	{
		return privatedeveloperName;
	}
	public final void setDeveloperName(String value)
	{
		privatedeveloperName = value;
	}

	private String privatelabel;
	public final String getLabel()
	{
		return privatelabel;
	}
	public final void setLabel(String value)
	{
		privatelabel = value;
	}

	private java.util.ArrayList<PageContainerAPI> privatepageContainers;
	public final java.util.ArrayList<PageContainerAPI> getPageContainers()
	{
		return privatepageContainers;
	}
	public final void setPageContainers(java.util.ArrayList<PageContainerAPI> value)
	{
		privatepageContainers = value;
	}

	private int privateorder;
	public final int getOrder()
	{
		return privateorder;
	}
	public final void setOrder(int value)
	{
		privateorder = value;
	}

	private java.util.HashMap<String, String> privateattributes;
	public final java.util.HashMap<String, String> getAttributes()
	{
		return privateattributes;
	}
	public final void setAttributes(java.util.HashMap<String, String> value)
	{
		privateattributes = value;
	}

	private java.util.ArrayList<PageTagAPI> privatetags;
	public final java.util.ArrayList<PageTagAPI> getTags()
	{
		return privatetags;
	}
	public final void setTags(java.util.ArrayList<PageTagAPI> value)
	{
		privatetags = value;
	}
}