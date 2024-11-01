InventoryMS Roles and Privileges Summary

Role	             Description/Privileges
Admin	             Full control over all the data in the system including users, inventories, financial transaction and more
Inventory Manager	 Manages products, stock, suppliers, and reports
Sales Manager	     Manages orders, customers, and sales reports
Warehouse Staff	     Update stock levels, manage orders and shipments
Procurement Manager	 Manage suppliers, purchase orders, and stock levels
Customer Support	 Handle customer queries and order statuses
Auditor	             Read-only access to all entities
Customer	         View products, place orders, track shipments
Supplier           	Manage their own products and view orders
Finance Manager   	Handle payments and financial reports


1. Admin/Super-Admin/Super-User
The Admin or Super-Admin (sometimes called Super-User) role has full control over the system, managing users, inventory, orders, and more. It could have the following privileges

CREATE_USER	      UPDATE_USER	      DELETE_USER
VIEW_USER	      CREATE_ROLE	      UPDATE_ROLE
DELETE_ROLE	      VIEW_ROLE	          MANAGE_PERMISSIONS
CREATE_PRODUCT	  UPDATE_PRODUCT	  DELETE_PRODUCT
VIEW_PRODUCT	  CREATE_ORDER	      UPDATE_ORDER
DELETE_ORDER	  VIEW_ORDER	      CREATE_SUPPLIER
UPDATE_SUPPLIER	  DELETE_SUPPLIER	  VIEW_SUPPLIER
VIEW_REPORTS	

2. Inventory Admin/Manager
This role handles all inventory-related tasks, including managing products, stock levels, and supplier relationships and has the following privileges.

CREATE_PRODUCT	UPDATE_PRODUCT	DELETE_PRODUCT
VIEW_PRODUCT	VIEW_STOCK_LEVEL	ORDER_STOCK
CREATE_SUPPLIER	UPDATE_SUPPLIER	VIEW_SUPPLIER
VIEW_INVENTORY_REPORTS

3. Sales Admin/Manager
The Sales Manager is responsible for managing customer orders, tracking inventory, and generating sales reports. The following privileges could be applied.

VIEW_PRODUCT	VIEW_STOCK_LEVEL
CREATE_ORDER	UPDATE_ORDER
DELETE_ORDER	VIEW_ORDER
VIEW_SALES_REPORTS	VIEW_CUSTOMERS


4.. Warehouse Staff/Personnel
This role deals with managing stock levels, handling shipments, and updating inventory statuses.

VIEW_PRODUCT	VIEW_STOCK_LEVEL
CREATE_ORDER	UPDATE_ORDER
DELETE_ORDER	VIEW_ORDER
VIEW_SALES_REPORTS	VIEW_CUSTOMERS

5. Procurement Admin/Manager
Handles all procurement activities, including managing supplier relationships and purchasing stock.

CREATE_SUPPLIER	UPDATE_SUPPLIER
VIEW_SUPPLIER	CREATE_PURCHASE_ORDER
VIEW_PURCHASE_ORDER	APPROVE_PURCHASE_ORDER
RECEIVE_PURCHASE_ORDER	VIEW_STOCK_LEVEL

6. Customer Support
This role manages customer queries, order statuses, and tracks shipments.

VIEW_ORDER
UPDATE_ORDER_STATUS
VIEW_CUSTOMER
CREATE_CUSTOMER
UPDATE_CUSTOMER
VIEW_SHIPMENT_STATUS

7.  Auditor
This role only has read access to the system for auditing purposes and cannot make any changes.

VIEW_PRODUCT	VIEW_ORDER
VIEW_SUPPLIER	VIEW_USER
VIEW_REPORTS	VIEW_AUDIT_LOG

8. Customer
For customers using the system to view and place orders.

VIEW_PRODUCT	PLACE_ORDER
VIEW_ORDER_STATUS	CANCEL_ORDER
UPDATE_PROFILE

9.  Supplier
If the system allows suppliers to log in and manage their products and orders, you can define this role.

VIEW_ORDERS	VIEW_PRODUCT
UPDATE_PRODUCT_DETAILS	VIEW_PAYMENT_STATUS

10. Finance Admin/Manager
Handles all payment and financial reporting tasks, including processing payments and generating financial reports.

VIEW_ORDER	PROCESS_PAYMENT
VIEW_PAYMENT_STATUS	VIEW_FINANCIAL_REPORTS
 