/*
Copyright (c) 2000-2013 "independIT Integrative Technologies GmbH",
Authors: Ronald Jeninga, Dieter Stubler

schedulix Enterprise Job Scheduling System

independIT Integrative Technologies GmbH [http://www.independit.de]
mailto:contact@independit.de

This file is part of schedulix

schedulix is free software:
you can redistribute it and/or modify it under the terms of the
GNU Affero General Public License as published by the
Free Software Foundation, either version 3 of the License,
or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package de.independit.scheduler.server.repository;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.sql.*;

import de.independit.scheduler.server.*;
import de.independit.scheduler.server.util.*;
import de.independit.scheduler.server.exception.*;

public class SDMSnpSrvrSRFootprintProxyGeneric extends SDMSProxy
{

	public final static long privilegeMask = SDMSPrivilege.ALL;

	protected SDMSnpSrvrSRFootprintProxyGeneric(SDMSObject p_object)
	{
		super(p_object);
	}

	protected static SDMSnpSrvrSRFootprint getProxy (SystemEnvironment sysEnv, SDMSObject p_object)
	{
		int i = SDMSnpSrvrSRFootprintTable.table.tableIndex;
		SDMSProxy p = SDMSRepository.getProxy(i);
		if (p == null)
			p = new SDMSnpSrvrSRFootprint (p_object);
		else {
			p.initProxy(p_object);
		}
		sysEnv.tx.addUsedProxy(i, p);
		return (SDMSnpSrvrSRFootprint)p;
	}

	public Long getSId (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSnpSrvrSRFootprintGeneric)(object)).getSId (env));
	}

	public void setSId (SystemEnvironment env, Long p_sId)
	throws SDMSException
	{
		checkWrite(env);
		((SDMSnpSrvrSRFootprintGeneric)(object)).setSId (env, p_sId);
		return ;
	}
	public Integer getSessionId (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSnpSrvrSRFootprintGeneric)(object)).getSessionId (env));
	}

	public void setSessionId (SystemEnvironment env, Integer p_sessionId)
	throws SDMSException
	{
		checkWrite(env);
		((SDMSnpSrvrSRFootprintGeneric)(object)).setSessionId (env, p_sessionId);
		return ;
	}
	public HashMap getFp (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSnpSrvrSRFootprintGeneric)(object)).getFp (env));
	}

	public void setFp (SystemEnvironment env, HashMap p_fp)
	throws SDMSException
	{
		checkWrite(env);
		((SDMSnpSrvrSRFootprintGeneric)(object)).setFp (env, p_fp);
		return ;
	}
	public Long getCreatorUId (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSnpSrvrSRFootprintGeneric)(object)).getCreatorUId (env));
	}

	private void setCreatorUId (SystemEnvironment env, Long p_creatorUId)
	throws SDMSException
	{
		checkWrite(env);
		((SDMSnpSrvrSRFootprintGeneric)(object)).setCreatorUId (env, p_creatorUId);
		return ;
	}
	public Long getCreateTs (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSnpSrvrSRFootprintGeneric)(object)).getCreateTs (env));
	}

	private void setCreateTs (SystemEnvironment env, Long p_createTs)
	throws SDMSException
	{
		checkWrite(env);
		((SDMSnpSrvrSRFootprintGeneric)(object)).setCreateTs (env, p_createTs);
		return ;
	}
	public Long getChangerUId (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSnpSrvrSRFootprintGeneric)(object)).getChangerUId (env));
	}

	public void setChangerUId (SystemEnvironment env, Long p_changerUId)
	throws SDMSException
	{
		checkWrite(env);
		((SDMSnpSrvrSRFootprintGeneric)(object)).setChangerUId (env, p_changerUId);
		return ;
	}
	protected SDMSnpSrvrSRFootprint setChangerUIdNoCheck (SystemEnvironment env, Long p_changerUId)
	throws SDMSException
	{
		checkWrite(env);
		((SDMSnpSrvrSRFootprintGeneric)(object)).setChangerUId (env, p_changerUId);
		return (SDMSnpSrvrSRFootprint)this;
	}
	public Long getChangeTs (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSnpSrvrSRFootprintGeneric)(object)).getChangeTs (env));
	}

	private void setChangeTs (SystemEnvironment env, Long p_changeTs)
	throws SDMSException
	{
		checkWrite(env);
		((SDMSnpSrvrSRFootprintGeneric)(object)).setChangeTs (env, p_changeTs);
		return ;
	}
	protected SDMSnpSrvrSRFootprint setChangeTsNoCheck (SystemEnvironment env, Long p_changeTs)
	throws SDMSException
	{
		checkWrite(env);
		((SDMSnpSrvrSRFootprintGeneric)(object)).setChangeTs (env, p_changeTs);
		return (SDMSnpSrvrSRFootprint)this;
	}

	public SDMSKey getSortKey(SystemEnvironment sysEnv)
	throws SDMSException
	{
		SDMSKey s = new SDMSKey();
		s.add(getId(sysEnv));
		return s;
	}

	public final boolean checkPrivileges(SystemEnvironment env, long p)
	throws SDMSException
	{
		return (getPrivileges(env, p, true, null) & p) == p;
	}

	public long getPrivilegeMask()
	{
		return privilegeMask;
	}

	public final SDMSPrivilege getPrivileges(SystemEnvironment env)
	throws SDMSException
	{
		return new SDMSPrivilege(env, getPrivileges(env, privilegeMask, false, null));
	}

	public final SDMSPrivilege getPrivilegesForGroups(SystemEnvironment env, Vector checkGroups)
	throws SDMSException
	{
		return new SDMSPrivilege(env, getPrivileges(env, privilegeMask, false, checkGroups));
	}

	public long getPrivileges(SystemEnvironment env, long checkPrivs, boolean fastFail, Vector checkGroups)
	throws SDMSException
	{
		Vector groups;
		if (checkGroups == null) groups = new Vector();
		else groups = checkGroups;

		long p = 0;
		p = checkPrivs;
		return p;
	}

	public SDMSMessage accessViolationMessage(SystemEnvironment sysEnv, String errno)
	throws SDMSException
	{
		SDMSMessage m;
		m = new SDMSMessage(sysEnv, errno, "Insufficient privileges accessing npSrvrSRFootprint $1", getId(sysEnv));
		return m;
	}

	protected void touch(SystemEnvironment env)
	throws SDMSException
	{
		setChangerUIdNoCheck (env, env.cEnv.uid());
		setChangeTsNoCheck (env, env.txTime());
	}

	public void print()
	{
		((SDMSnpSrvrSRFootprintGeneric) object).print();
	}
}
