== Problem ==
A RESTful service that implments a check out counter for an online retail store that scans products and generates an itemized bill.
The bill should also total the cost of all the products and the applicable sales tax for each product.
The total cost and total sales tax should be printed
Sales tax varies based on the type of products
* category A products carry a levy of 10%
* category B products carry a levy of 20%
* category C products carry no levy

== Solution ==

POST method 
URL : http://localhost:8080/billing/bill
Content-Type : application/vnd.base.bill.request+json
Accept : application/vnd.base.bill+json
Request Body 
{
	"products": [{
			"productName": "Oil",
			"productCategory": "A",
			"rate": 50.55
		},
		{
			"productName": "Milk",
			"productCategory": "B",
			"rate": 20.3
		},
		{
			"productName": "suger",
			"productCategory": "C",
			"rate": 10.8
		}
	]
}

GET method : for get bill by id.
URL : http://localhost:8080/billing/getBillById/{id}

GET method : for get all bills
URL : http://localhost:8080/billing/getBills

DELETE method : remove all bills
URL : http://localhost:8080/billing/removeAllBills

