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

import java.util.*;

public class SDMSKey extends Vector implements Comparable
{

	public final static String __version = "@(#) $Id: SDMSKey.java,v 2.1.18.1 2013/03/14 10:25:19 ronald Exp $";

	public SDMSKey()
	{
		super();
	}

	public SDMSKey(Comparable c1)
	{
		super();
		this.add(c1);
	}

	public SDMSKey(Comparable c1, Comparable c2)
	{
		super();
		this.add(c1);
		this.add(c2);
	}

	public SDMSKey(Comparable c1, Comparable c2, Comparable c3)
	{
		super();
		this.add(c1);
		this.add(c2);
		this.add(c3);
	}

	public SDMSKey(Comparable c1, Comparable c2, Comparable c3, Comparable c4)
	{
		super();
		this.add(c1);
		this.add(c2);
		this.add(c3);
		this.add(c4);
	}

	public int compareTo(Object o)
	{
		SDMSKey k = (SDMSKey) o;
		int ks, ts, ms;
		int i, r;
		Comparable c1, c2;

		ks = k.size();
		ts = this.size();
		ms = (ks > ts ? ts : ks);
		for(i = 0; i<ms; i++) {
			c1 = (Comparable) get(i);
			c2 = (Comparable) k.get(i);
			if (c1 == null && c2 != null) return -1;
			if (c1 != null && c2 == null) return 1;
			if (c1 == null && c2 == null) continue;

			r = c1.compareTo(c2);
			if(r != 0) return r;
		}
		if(ks > ts) return -1;
		if(ks < ts) return 1;
		return 0;
	}

	public void add(Comparable c)
	{
		super.add(c);
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		String sep = "";
		sb.append('[');
		for (int i = 0; i < this.size(); ++i) {
			Object o = get(i);
			sb.append(sep);
			sb.append((o == null ? "null" : o.toString()));
			sep = ", ";
		}
		sb.append(']');

		return sb.toString();
	}

}
