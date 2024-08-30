package com.qa.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.query.QueryOptions;
import com.couchbase.client.java.query.QueryResult;

import stepDefinitions.BaseTest;

public class CouchbaseConnection2 {
	
	public String fetchValueFromdatabase(String refID,String header) {
	//public static void main(String arg[]) {

		// static String connectionString =
		// "couchbases://cb.<your-endpoint-here>.cloud.couchbase.com";
		String username = "ngoel";
		String password = "P[]dmxuNcGw6Uk2Bj#Wnsh";
		String hostname = "couchbase://172.168.128.202";

		String bucket_name = "dev001";
		//String Query = "SELECT ROUND(SUM(paidTax), 2) AS total_tax FROM `dev001` WHERE docType='orderSummary' and locationID='842564CF-2899-46E3-A191-599E941E8E1D' and empName='Charge Admin' and commChannel='C2461' AND isPurged = 0   AND dateCreated BETWEEN 	1721518199000 AND 	1721777399000";
		String Query="SELECT "+header+" FROM `dev001` WHERE docType='order' and commChannel='C2461' and locationID='842564CF-2899-46E3-A191-599E941E8E1D' and isPurged=0 and status=1 AND refNumber='"+refID+"'";
		// Connect to Couchbase cluster
		Cluster cluster = Cluster.connect(hostname, username, password);

		// Access a specific bucket (or collection in Couchbase 7.0+)
		Collection collection = cluster.bucket(bucket_name).defaultCollection();

		// Execute the query
		QueryResult result = cluster.query(Query, QueryOptions.queryOptions());

		// Process the results
		StringBuilder stringBuilder = new StringBuilder();
		for (JsonObject row : result.rowsAsObject()) {
			// Append each row as a string to the StringBuilder
			stringBuilder.append(row).append("\n"); // Append each row and add a newline
		}

		// Disconnect from the cluster
		cluster.disconnect();
		System.out.println(stringBuilder.toString());
		
		// Return the concatenated result as a string
		String databasesubtotal = stringBuilder.toString();
		String databasesubtotals[] = databasesubtotal.split(",");
		String cell = header;
		String datas[] = null;
		for (String data : databasesubtotals) {
			if (data.contains(cell)) {
				datas = data.split(":");
				datas[1] = datas[1].replace('"', ' ').replace("}", "").replace(" ", "");
				String regex = "\\$([\\d\\.]+)";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(datas[1]);
				if (matcher.find()) {
					datas[1] = matcher.group(1);
					// Extract the matched group
				}
				System.out.println(datas[1]);

			}
		}return datas[1];

	}
}
