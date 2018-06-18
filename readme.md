== Problem ==
A RESTful service that implments a check out counter for an online retail store that scans products and generates an itemized bill.
The bill should also total the cost of all the products and the applicable sales tax for each product.
The total cost and total sales tax should be printed
Sales tax varies based on the type of products
* category A products carry a levy of 10%
* category B products carry a levy of 20%
* category C products carry no levy

== Solution ==

POST method /bill with list of products as request e.g.;
{
	{
		"productName" : "Oil",
		"productCategory" : "A",
		"rate" : 50.55
	},
	{
		"productName" : "milk",
		"productCategory" : "B",
		"rate" : 20.3
	},
	{
		"productName" : "suger",
		"productCategory" : "c",
		"rate" : 20
	}
}

GET method to get bill by given id /getBillByid/{id}