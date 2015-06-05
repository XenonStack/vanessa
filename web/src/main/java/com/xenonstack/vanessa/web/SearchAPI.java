
package com.xenonstack.vanessa.web;


import java.util.ArrayList;
import com.xenonstack.vanessa.configuration.Configuration;
import java.util.List;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
public class SearchAPI
{
	public List serach(String value) throws Exception
	{
		String key="content";
		value="Main";
		List list=new ArrayList(); 
		Configuration conf=new Configuration();
		String server_url=conf.get("solr.server").toString();
		HttpSolrServer solr = new HttpSolrServer(server_url);
		SolrQuery query = new SolrQuery(key+":"+value);
		QueryResponse response = solr.query(query);
		SolrDocumentList results = response.getResults();
		for (int i = 0; i < results.size(); ++i)
		{
		   list.add(results.get(i));
		}
		     return list;
	}
}

