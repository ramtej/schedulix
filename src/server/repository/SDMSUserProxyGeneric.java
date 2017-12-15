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

public class SDMSUserProxyGeneric extends SDMSProxy
{

	public final static String SYSTEM = "SYSTEM";
	public final static String INTERNAL = "INTERNAL";
	public final static String NOBODY = "NOBODY";
	public final static int MD5 = 0;
	public final static int SHA256 = 1;
	public final static int PLAIN = 0;
	public final static int SSL = 1;
	public final static int SSL_AUTH = 2;
	public final static int SALT_LENGTH = 64;
	public final static long privilegeMask = SDMSPrivilege.EDIT|SDMSPrivilege.CREATE|SDMSPrivilege.VIEW|SDMSPrivilege.DROP|SDMSPrivilege.GRANT;

	static final public int name_size = 64;
	static final public int passwd_size = 64;
	static final public int salt_size = 64;

	protected SDMSUserProxyGeneric(SDMSObject p_object)
	{
		super(p_object);
	}

	protected static SDMSUser getProxy (SystemEnvironment sysEnv, SDMSObject p_object)
	{
		int i = SDMSUserTable.table.tableIndex;
		SDMSProxy p = SDMSRepository.getProxy(i);
		if (p == null)
			p = new SDMSUser (p_object);
		else {
			p.initProxy(p_object);
		}
		sysEnv.tx.addUsedProxy(i, p);
		return (SDMSUser)p;
	}

	public String getName (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSUserGeneric)(object)).getName (env));
	}

	public void setName (SystemEnvironment env, String p_name)
	throws SDMSException
	{
		checkWrite(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181241"));

		((SDMSUserGeneric)(object)).setName (env, p_name);
		return ;
	}
	public static int getNameMaxLength ()
	{
		return (64);
	}
	public String getPasswd (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSUserGeneric)(object)).getPasswd (env));
	}

	public void setPasswd (SystemEnvironment env, String p_passwd)
	throws SDMSException
	{
		checkWrite(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181241"));

		((SDMSUserGeneric)(object)).setPasswd (env, p_passwd);
		return ;
	}
	public static int getPasswdMaxLength ()
	{
		return (64);
	}
	public String getSalt (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSUserGeneric)(object)).getSalt (env));
	}

	public void setSalt (SystemEnvironment env, String p_salt)
	throws SDMSException
	{
		checkWrite(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181241"));

		((SDMSUserGeneric)(object)).setSalt (env, p_salt);
		return ;
	}
	public static int getSaltMaxLength ()
	{
		return (64);
	}
	public Integer getMethod (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSUserGeneric)(object)).getMethod (env));
	}

	public String getMethodAsString (SystemEnvironment env)
	throws SDMSException
	{
		checkRead (env);
		return ((SDMSUserGeneric) object).getMethodAsString (env);
	}

	public void setMethod (SystemEnvironment env, Integer p_method)
	throws SDMSException
	{
		checkWrite(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181241"));

		((SDMSUserGeneric)(object)).setMethod (env, p_method);
		return ;
	}
	public Boolean getIsEnabled (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSUserGeneric)(object)).getIsEnabled (env));
	}

	public void setIsEnabled (SystemEnvironment env, Boolean p_isEnabled)
	throws SDMSException
	{
		checkWrite(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181241"));

		((SDMSUserGeneric)(object)).setIsEnabled (env, p_isEnabled);
		return ;
	}
	public Long getDefaultGId (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSUserGeneric)(object)).getDefaultGId (env));
	}

	public void setDefaultGId (SystemEnvironment env, Long p_defaultGId)
	throws SDMSException
	{
		checkWrite(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181241"));

		((SDMSUserGeneric)(object)).setDefaultGId (env, p_defaultGId);
		return ;
	}
	public Integer getConnectionType (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSUserGeneric)(object)).getConnectionType (env));
	}

	public String getConnectionTypeAsString (SystemEnvironment env)
	throws SDMSException
	{
		checkRead (env);
		return ((SDMSUserGeneric) object).getConnectionTypeAsString (env);
	}

	public void setConnectionType (SystemEnvironment env, Integer p_connectionType)
	throws SDMSException
	{
		checkWrite(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181241"));

		((SDMSUserGeneric)(object)).setConnectionType (env, p_connectionType);
		return ;
	}
	public Long getDeleteVersion (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSUserGeneric)(object)).getDeleteVersion (env));
	}

	public void setDeleteVersion (SystemEnvironment env, Long p_deleteVersion)
	throws SDMSException
	{
		checkWrite(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181241"));

		((SDMSUserGeneric)(object)).setDeleteVersion (env, p_deleteVersion);
		return ;
	}
	public Long getCreatorUId (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSUserGeneric)(object)).getCreatorUId (env));
	}

	private void setCreatorUId (SystemEnvironment env, Long p_creatorUId)
	throws SDMSException
	{
		checkWrite(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181241"));

		((SDMSUserGeneric)(object)).setCreatorUId (env, p_creatorUId);
		return ;
	}
	public Long getCreateTs (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSUserGeneric)(object)).getCreateTs (env));
	}

	private void setCreateTs (SystemEnvironment env, Long p_createTs)
	throws SDMSException
	{
		checkWrite(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181241"));

		((SDMSUserGeneric)(object)).setCreateTs (env, p_createTs);
		return ;
	}
	public Long getChangerUId (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSUserGeneric)(object)).getChangerUId (env));
	}

	public void setChangerUId (SystemEnvironment env, Long p_changerUId)
	throws SDMSException
	{
		checkWrite(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181241"));

		((SDMSUserGeneric)(object)).setChangerUId (env, p_changerUId);
		return ;
	}
	protected SDMSUser setChangerUIdNoCheck (SystemEnvironment env, Long p_changerUId)
	throws SDMSException
	{
		checkWrite(env);
		((SDMSUserGeneric)(object)).setChangerUId (env, p_changerUId);
		return (SDMSUser)this;
	}
	public Long getChangeTs (SystemEnvironment env)
	throws SDMSException
	{
		checkRead(env);
		return (((SDMSUserGeneric)(object)).getChangeTs (env));
	}

	private void setChangeTs (SystemEnvironment env, Long p_changeTs)
	throws SDMSException
	{
		checkWrite(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181241"));

		((SDMSUserGeneric)(object)).setChangeTs (env, p_changeTs);
		return ;
	}
	protected SDMSUser setChangeTsNoCheck (SystemEnvironment env, Long p_changeTs)
	throws SDMSException
	{
		checkWrite(env);
		((SDMSUserGeneric)(object)).setChangeTs (env, p_changeTs);
		return (SDMSUser)this;
	}
	public SDMSUser set_NameDeleteVersion (SystemEnvironment env, String p_name, Long p_deleteVersion)
	throws SDMSException
	{
		checkRead(env);
		if(!checkPrivileges(env, SDMSPrivilege.EDIT))
			throw new AccessViolationException (accessViolationMessage(env, "01312181242"));

		((SDMSUserGeneric)(object)).set_NameDeleteVersion (env, p_name, p_deleteVersion);
		return (SDMSUser)this;
	}

	public SDMSKey getSortKey(SystemEnvironment sysEnv)
	throws SDMSException
	{
		SDMSKey s = null;
		Long myId = getId(sysEnv);
		if (sysEnv.tx.sortKeyMap == null)
			sysEnv.tx.sortKeyMap = new HashMap();
		else
			s = (SDMSKey) sysEnv.tx.sortKeyMap.get(myId);
		if (s != null) return s;
		boolean gotIt = false;
		s = new SDMSKey();

		s.add(getName(sysEnv));

		sysEnv.tx.sortKeyMap.put(myId, s);
		return s;
	}

	public void delete (SystemEnvironment env)
	throws SDMSException
	{
		SDMSObjectCommentTable.dropComment (env, getId (env));
		Vector gv = SDMSGrantTable.idx_objectId.getVector(env, getId(env));
		for (int i = 0; i < gv.size(); ++i) {
			SDMSGrant g = (SDMSGrant) gv.get(i);
			g.delete(env);
		}
		super.delete(env);
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
		if(env.cEnv.isUser() || env.cEnv.isJob()) {
			if (env.cEnv.isJob()) {
				HashSet hg = new HashSet();
				SDMSSubmittedEntity sme = SDMSSubmittedEntityTable.getObject(env, env.cEnv.uid());
				Long smeOwner = sme.getOwnerId(env);
				hg.add(smeOwner);
				hg.add(SDMSObject.publicGId);
				env.cEnv.pushGid(env, hg);
			}
			if(checkGroups == null)
				groups.addAll(env.cEnv.gid());
			if(groups.contains(SDMSObject.adminGId)) p = checkPrivs;
			else {
			}
		} else p = checkPrivs;
		return p;
	}

	public SDMSMessage accessViolationMessage(SystemEnvironment sysEnv, String errno)
	throws SDMSException
	{
		SDMSMessage m;
		m = new SDMSMessage(sysEnv, errno, "Insufficient privileges accessing User $1", getName(sysEnv));
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
		((SDMSUserGeneric) object).print();
	}
}
