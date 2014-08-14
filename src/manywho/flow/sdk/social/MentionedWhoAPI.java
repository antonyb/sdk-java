﻿package manywho.flow.sdk.social;

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

public class MentionedWhoAPI extends JSONObject implements Serializable
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

	private String privatename;
	public final String getName()
	{
		return privatename;
	}
	public final void setName(String value)
	{
		privatename = value;
	}

	private String privatefullName;
	public final String getFullName()
	{
		return privatefullName;
	}
	public final void setFullName(String value)
	{
		privatefullName = value;
	}

	private String privatejobTitle;
	public final String getJobTitle()
	{
		return privatejobTitle;
	}
	public final void setJobTitle(String value)
	{
		privatejobTitle = value;
	}

	private String privateavatarUrl;
	public final String getAvatarUrl()
	{
		return privateavatarUrl;
	}
	public final void setAvatarUrl(String value)
	{
		privateavatarUrl = value;
	}
}