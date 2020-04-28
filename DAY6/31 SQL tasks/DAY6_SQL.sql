/*1. Выбрать все строки из таблицы c перевозчиками.*/
select * from Shippers;

/*2. Выбрать первые 3 строки из таблицы c сотрудниками.*/
select * from Employees limit 3;

/*3. Из таблицы сотрудников выбрать все имена, фамилии, дни рождения в следующем порядке: BirthDate, FirstName, LastName, количество строк в выборке ограничить 3-мя.*/
select e.BirthDate, e.FirstName, e.LastName from Employees e limit 3;

/*4. Выбрать имена и фамлии сотрудников, родившихся в 1958 году.*/
select e.FirstName, e.LastName from Employees e where e.BirthDate like '1958%';

/*5. Выбрать все товары с ценой от 23 до 25.*/
select * from Products p where p.Price between 23 and 25;
 
/*6. Найти товары с минимальной ценой.*/
select * from Products where Price in (select min(Price) from Products);

/*7. Найти товары с максимальной ценой.*/
select * from Products where Price in (select max(Price) from Products);

/*8. Выбрать все товары, у которых Unit '10 pkgs.'.*/
select * from Products p where p.Unit like '10 pkgs.';

/*9. Выбрать адреса поставщиков, которые проживают в одном из городов: Tokyo, Frankfurt, Osaka.*/
select s.Address from Suppliers s where s.City in ('Tokyo', 'Frankfurt', 'Osaka');

/*10. Выбрать название товаров начинающихся с буквы “G”, у которых цена больше 37.*/
select p.ProductName from Products p where p.ProductName like 'G%' and p.Price > 37;

/*11. Вывести список стран начинающихся на S и состоящих из 5 букв, из которых есть поставщики.*/
select s.Country from Suppliers s where s.Country like 'S%' and char_length(Country) = 5;

/*12. Вывести сумму всех товаров, в названии которых содержится ”od”, столбец назвать Summ.*/
select sum(Price) as Summ from Products p where p.ProductName like '%od%';

/*13. Вывести среднюю стоимость товаров, поставляемых в бутылках, округлив до 2-х знаков после запятой, столбец назвать Summ. */
select round((avg(Price)), 2) as Summ from Products p where p.Unit like '%bottle%';

/*14. Найти количество клиентов, которые НЕ проживают в Франции и Германии,  столбец назвать Countt.*/
select count(*) as Countt from Customers c where c.Country not in ('Germany','France');

/*15. Вывести имена сотрудников, родившихся после 01.01.1968 года. Отсортировать результат по имени. */
select e.FirstName from Employees e where e.BirthDate > str_to_date('1968-01-01', '%Y-%m-%d') order by e.FirstName;

/*16. Выбрать названия товаров, у которых Price = 13 или 15 и отсортировать по возрастанию, использовать Select команды с объединением результатов через UNION.*/
select p.ProductName from Products p where p.Price in (13,15) order by p.ProductName;

/*17. Показать имена товаров, в названии которых третяя буква m и названия их поставщиков.*/
select p.ProductName, s.SupplierName from Products p
join Suppliers s on p.SupplierID = s.SupplierID
where p.ProductName like '__m%';

/*18. Показать имена и фамилии сотрудника, который оформил заказ 1996-11-27 (написать запрос двумя способами: через INNER Join, и используя подзапрос).*/
/* var1 via INNER JOIN*/
select e.FirstName, e.LastName from Employees e
join Orders o on e.EmployeeID = o.EmployeeID
where o.OrderDate = '1996-11-27';
/*var2 via sub-request*/
select e.FirstName, e.LastName from Employees e where e.EmployeeID in
(select o.EmployeeID from Orders o where o.OrderDate = '1996-11-27');

/*19. Выбрать все товары, у которых поставщик «Grandma Kelly's Homestead» и цена > 27. В результате вывести 3 колонки: Product, Supplier, Price.*/
select p.ProductName, s.SupplierName, p.Price from Products p
join Suppliers s on p.SupplierID = s.SupplierID
where s.SupplierName = "Grandma Kelly's Homestead"
and p.Price > 27;

/*20. Вывести суммарное количество продукта 'Queso Cabrales' (столбец обозвать Summ), отправленного всем покупателям.*/
select sum(o.Quantity) from OrderDetails o
where o.ProductID = (select p.ProductID from Products p where p.ProductName = 'Queso Cabrales');

/*21. Показать все заказы, которые были отправлены по адресу «Ekergatan 24» с их заказчиками и сотрудниками.
В результате вывести 3 колонки – ID заказа, имя заказчика, имя сотрудника, фамилия сотрудника.*/
select o.OrderID, c.CustomerName, e.FirstName, e.LastName from Customers c
join Orders o on c.CustomerID = o.CustomerID
join Employees e on e.EmployeeID = o.EmployeeID
where c.Address = 'Ekergatan 24';

/*22. Преобразовать предыдущий запрос таким образом, чтобы те же данные выводились
 в 3-х колонках – объединить LastName и FirstName из Employees в одну колонку через пробел и назвать ее EmployeeName (2 LEFT JOINS).*/
select o.OrderID, c.CustomerName, concat(e.FirstName, ' ' ,e.LastName) as EmployeeName from Customers c
join Orders o on c.CustomerID = o.CustomerID
join Employees e on e.EmployeeID = o.EmployeeID
where c.Address = 'Ekergatan 24';

/*23. Показать все продукты, содержащиеся в заказах 1997-го года и в названии которых менее 5 букв. В результате вывести OrderID, OrderDate, ProductName.*/
select o.OrderID, o.OrderDate, p.ProductName from Orders o 
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
where year(o.OrderDate) = '1997'
and char_length(p.ProductName) < 5;

/*24. Показать названия продуктов и их категорий,
 которые используются в заказах от заказчика по имени Blondel père et fils и категории которых состоят как минимум из 2-х слов.*/
select c.CategoryName, p.ProductName from Products p
join Categories c on p.CategoryID = c.CategoryID
join OrderDetails od on od.ProductID = p.ProductID
join Orders o on od.OrderID = o.OrderID
where length(c.CategoryName) - length(replace(c.CategoryName, ' ', '')) + 1 > 1
and o.CustomerID in (select ct.CustomerID from Customers ct where ct.CustomerName = 'Blondel père et fils');

/*25. Вывести количество заказчиков (колонку назвать Buyers), которые заказали один из продуктов:
 «Queso Cabrales», «Gustaf's Knäckebröd», «Louisiana Fiery Hot Pepper Sauce», «Schoggi Schokolade», «Gnocchi di nonna Alice».*/
 select count(Distinct o.CustomerID) as Buyers from Products p
 join OrderDetails od on p.ProductID = od.ProductID
 join Orders o on o.OrderID = od.OrderID
 where p.ProductName in ("Queso Cabrales", "Gustaf's Knäckebröd", "Louisiana Fiery Hot Pepper Sauce", "Schoggi Schokolade", "Gnocchi di nonna Alice");
 
 /*26. *Найти города в которые было отправлено больше всего заказов, вывести назание города и количество заказов (колонку назвать Amount).*/
select c.City City, count(o.OrderID) Amount 
from Customers c
join Orders o on c.CustomerID = o.CustomerID
group by c.City
having Amount = (
	select max(orderCounts.Summ) maxSumm
	from (select c.City, count(o.OrderID) Summ from Customers c
	join Orders o on c.CustomerID = o.CustomerID
	group by c.City) orderCounts);
    
/*27. *Найти из какого города было поставлено наибольшее количество единиц товаров в Лондон, вывести название города и количество единиц (колонку назвать Amount).*/
select s.City City, sum(od.Quantity) Amount
from Orders o
join OrderDetails od on od.OrderID = o.OrderID
join Products p on od.ProductID = p.ProductID
join Suppliers s on p.SupplierID = s.SupplierID
where o.CustomerID in (
	select c.CustomerID 
    from Customers c 
	where c.City = 'London')
group by s.City
having Amount = (select max(template.Amount)
from (select sum(od.Quantity) Amount
from Orders o
join OrderDetails od on od.OrderID = o.OrderID
join Products p on od.ProductID = p.ProductID
join Suppliers s on p.SupplierID = s.SupplierID
where o.CustomerID in (
	select c.CustomerID 
    from Customers c 
	where c.City = 'London')
group by s.City) as template)
order by Amount desc;

/*28. *Найти перевозчиков, которые перевезли более 30 разнообразных напитков (Beverages), 
вывести имена перевозчиков, категорию товара и количество перевезенных видов товара (колонку назвать Amount).*/
select ShipperName, CategoryName, count(ProductName) as Amount 
from Categories c 
join Products p on c.CategoryID = p.CategoryID 
join OrderDetails od on p.ProductID = od.ProductID 
join Orders o on od.OrderID = o.OrderID 
join Shippers s on o.ShipperID = s.ShipperID 
where c.CategoryName = 'Beverages' 
group by ShipperName 
having Amount > 30;

/*29. *Найти среднюю стоимость приправ (Condiments) отправленных в штаты, заказы на которые оформлены Margaret Peacock,
 вывести стоимость округленную до 2-х знаков после запятой (колонку назвать Average)*/
select round(avg(Price),2) Average from Products p
join OrderDetails od on p.ProductID = od.ProductID
join Orders o on od.OrderID = o.OrderID
where p.CategoryID in (select ct.CategoryID from Categories ct
 where ct.CategoryName like 'Condiments')
and o.EmployeeID in (select e.EmployeeID from Employees e
 where e.FirstName = 'Margaret'
 and e.LastName = 'Peacock')
and o.CustomerID in (select c.CustomerID from Customers c
 where c.Country = 'USA');
 
 /*30. **Найти сотрудников, которые оформили заказов на такой процент от общей стоимости всех оформленных заказов,
 который больше, чем процент общей стоимости заказов оформленных сотрудником,
 о котром в базе содержится самое длинное примечание (Notes), к общей стоимости всех заказов,
 который были перевезены перевозчиками, у которых номер телефона совпадает с номером телефона одного из поставщиков. 
 Вывести полные имена сотрудников (в одной ячейке через пробел, назвав колонку EmployeeName) 
 и процент от общей стоимости оформленных ими заказов к общей стоимости всех заказов, 
 округленный до 2-х знаков после запятой, со значком процента через пробел после самой величины (назвав колонку Ratio).*/
-- 1. Найти общую стоимость оформленнных заказов (1)
-- 2. Найти в базе сотрудников с самым длинным примечанием (2)
-- 3. Найти процент заказов оформленных (2) от общей стоимости заказов
-- 4. Найти общую стоимость всех заказов перевезенных перевозчиками у которых №тел совпадает с номером тел одного из поставщиков
-- 5. Найти кол-во заказов (лучше процент от всех заказов) оформленны отдним сотрудником
/*1*/set @PriseAllOrder:= (select sum(OrdPriceTable.OrdPrice) from
(select o.OrderID, sum(od.Quantity*p.Price) OrdPrice from Products p
join OrderDetails od on p.ProductID = od.ProductID
join Orders o on od.OrderID = o.OrderID
group by o.OrderID
order by o.OrderID) OrdPriceTable);

/*2*/select e.EmployeeID, concat(e.FirstName, " ", e.LastName) EmployeeName  from Employees e
where char_length(e.Notes) = (select max(char_length(e.Notes)) from Employees e);
    
/*3*/set @EmployeeOrderPrice:=(select sum(od.Quantity*p.Price) OrdPrice from Products p
join OrderDetails od on p.ProductID = od.ProductID
join Orders o on od.OrderID = o.OrderID
where o.EmployeeID = (select e.EmployeeID EmployeeName  from Employees e
where char_length(e.Notes) = (select max(char_length(e.Notes)) from Employees e)) 
order by o.OrderID);

/*4*/set @PriseShippers:= (SELECT SUM(od.Quantity*p.Price) 
        FROM Shippers sh JOIN Orders o ON o.ShipperID  = sh.ShipperID JOIN OrderDetails od ON od.OrderID = o.OrderID JOIN Products p ON p.ProductID = od.ProductID 
		WHERE sh.ShipperID IN (
			SELECT sh.ShipperID FROM Shippers sh 
			JOIN Orders o ON o.ShipperID  = sh.ShipperID JOIN OrderDetails od ON od.OrderID = o.OrderID JOIN Products p ON p.ProductID = od.ProductID JOIN Suppliers s ON s.SupplierID = p.SupplierID 
			WHERE sh.Phone = s.Phone));

set @Prersent:=@EmployeeOrderPrice/@PriseShippers;


/*5*/select EmployeeName, concat(Ratio *100, " %") Ratio from 
(select concat(e.FirstName, " ", e.LastName) EmployeeName, round(sum(od.Quantity*p.Price)/@PriseAllOrder, 2) as Ratio from Products p
join OrderDetails od on p.ProductID = od.ProductID
join Orders o on od.OrderID = o.OrderID
join Employees e on o.EmployeeID = e.EmployeeID
group by EmployeeName
having Ratio > @Prersent) tab;

-- 31
-- сумма товаров по категориям
set @SummB := (select sum(p.Price*od.Quantity) sunB from Orders o
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
and ca.CategoryName = 'Beverages');

set @SummD := (select sum(p.Price*od.Quantity) sunB from Orders o
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
and ca.CategoryName = 'Dairy Products');

set @SummS := (select sum(p.Price*od.Quantity) sunB from Orders o
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
and ca.CategoryName = 'Seafood');


-- Beverages
select tabB.CustomerName, tabB.Beverages, tabD.DairyProducts, tabS.Seafood from (
select BeveragesSumm.CustomerName, concat(BeveragesSumm.BeveragesS, "   (" , BeveragesPers.BeveragesP, ")%") Beverages from(
select c.CustomerName, sum(p.Price*od.Quantity) BeveragesS from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Beverages'
group by c.CustomerName) BeveragesSumm
join 
(select c.CustomerName, round(sum(p.Price*od.Quantity)/@SummB*100, 2) BeveragesP from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Beverages'
group by c.CustomerName) BeveragesPers on BeveragesSumm.CustomerName = BeveragesPers.CustomerName) tabB
LEFT JOIN
-- Dairy Products
(select DairySumm.CustomerName, concat(DairyS, "   (", DairyP, ")%") DairyProducts from (
select c.CustomerName, sum(p.Price*od.Quantity) DairyS from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Dairy Products'
group by c.CustomerName) DairySumm
join 
(select c.CustomerName, round(sum(p.Price*od.Quantity)/@SummD*100, 2) DairyP from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Dairy Products'
group by c.CustomerName) DairyPers on DairySumm.CustomerName = DairyPers.CustomerName) tabD on tabB.CustomerName = tabD.CustomerName
LEFT JOIN
-- Seafood
(select SeafoodSumm.CustomerName, concat(SeafoodS, " (", SeafoodP, ")%") Seafood from (
select c.CustomerName, sum(p.Price*od.Quantity) SeafoodS from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Seafood'
group by c.CustomerName) SeafoodSumm
join
(select c.CustomerName, round(sum(p.Price*od.Quantity)/@SummS*100, 2) SeafoodP from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Seafood'
group by c.CustomerName) SeafoodPers on SeafoodSumm.CustomerName = SeafoodPers.CustomerName) tabS on tabD.CustomerName = tabS.CustomerName
-- __________________________________
UNION
select tabB.CustomerName, tabB.Beverages, tabD.DairyProducts, tabS.Seafood from (
select BeveragesSumm.CustomerName, concat(BeveragesSumm.BeveragesS, "   (" , BeveragesPers.BeveragesP, ")%") Beverages from(
select c.CustomerName, sum(p.Price*od.Quantity) BeveragesS from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Beverages'
group by c.CustomerName) BeveragesSumm
join 
(select c.CustomerName, round(sum(p.Price*od.Quantity)/@SummB*100, 2) BeveragesP from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Beverages'
group by c.CustomerName) BeveragesPers on BeveragesSumm.CustomerName = BeveragesPers.CustomerName) tabB
RIGHT JOIN
-- Dairy Products
(select DairySumm.CustomerName, concat(DairyS, "   (", DairyP, ")%") DairyProducts from (
select c.CustomerName, sum(p.Price*od.Quantity) DairyS from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Dairy Products'
group by c.CustomerName) DairySumm
join 
(select c.CustomerName, round(sum(p.Price*od.Quantity)/@SummD*100, 2) DairyP from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Dairy Products'
group by c.CustomerName) DairyPers on DairySumm.CustomerName = DairyPers.CustomerName) tabD on tabB.CustomerName = tabD.CustomerName
RIGHT JOIN
-- Seafood
(select SeafoodSumm.CustomerName, concat(SeafoodS, " (", SeafoodP, ")%") Seafood from (
select c.CustomerName, sum(p.Price*od.Quantity) SeafoodS from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Seafood'
group by c.CustomerName) SeafoodSumm
join
(select c.CustomerName, round(sum(p.Price*od.Quantity)/@SummS*100, 2) SeafoodP from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Seafood'
group by c.CustomerName) SeafoodPers on SeafoodSumm.CustomerName = SeafoodPers.CustomerName) tabS on tabD.CustomerName = tabS.CustomerName
UNION
select tabB.CustomerName, tabB.Beverages, tabD.DairyProducts, tabS.Seafood from (
select BeveragesSumm.CustomerName, concat(BeveragesSumm.BeveragesS, "   (" , BeveragesPers.BeveragesP, ")%") Beverages from(
select c.CustomerName, sum(p.Price*od.Quantity) BeveragesS from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Beverages'
group by c.CustomerName) BeveragesSumm
join 
(select c.CustomerName, round(sum(p.Price*od.Quantity)/@SummB*100, 2) BeveragesP from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Beverages'
group by c.CustomerName) BeveragesPers on BeveragesSumm.CustomerName = BeveragesPers.CustomerName) tabB
RIGHT JOIN
-- Dairy Products
(select DairySumm.CustomerName, concat(DairyS, "   (", DairyP, ")%") DairyProducts from (
select c.CustomerName, sum(p.Price*od.Quantity) DairyS from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Dairy Products'
group by c.CustomerName) DairySumm
join 
(select c.CustomerName, round(sum(p.Price*od.Quantity)/@SummD*100, 2) DairyP from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Dairy Products'
group by c.CustomerName) DairyPers on DairySumm.CustomerName = DairyPers.CustomerName) tabD on tabB.CustomerName = tabD.CustomerName
LEFT JOIN
-- Seafood
(select SeafoodSumm.CustomerName, concat(SeafoodS, " (", SeafoodP, ")%") Seafood from (
select c.CustomerName, sum(p.Price*od.Quantity) SeafoodS from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Seafood'
group by c.CustomerName) SeafoodSumm
join
(select c.CustomerName, round(sum(p.Price*od.Quantity)/@SummS*100, 2) SeafoodP from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderDetails od on o.OrderID = od.OrderID
join Products p on p.ProductID = od.ProductID
join Categories ca on p.CategoryID = ca.CategoryID
where c.City = 'Mexico D.F.'and ca.CategoryName = 'Seafood'
group by c.CustomerName) SeafoodPers on SeafoodSumm.CustomerName = SeafoodPers.CustomerName) tabS on tabD.CustomerName = tabS.CustomerName;