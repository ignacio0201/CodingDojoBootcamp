/*1. ¿Qué consulta ejecutaría para obtener los ingresos totales 
para marzo de 2012?*/

SELECT MONTHNAME(charged_datetime) AS month, SUM(billing.amount) AS revenue
FROM billing
WHERE YEAR(charged_datetime) = 2012 
AND MONTH(charged_datetime) = 3;

/*2. ¿Qué consulta ejecutaría para obtener los ingresos totales 
recaudados del cliente con una identificación de 2?*/

SELECT clients.client_id, SUM(billing.amount) AS total_revenue
FROM
clients INNER JOIN billing
ON clients.client_id = billing.client_id
WHERE clients.client_id = 2;

/*3. ¿Qué consulta ejecutaría para obtener todos los sitios que 
posee client = 10?*/

SELECT sites.domain_name AS website, clients.client_id
FROM
clients INNER JOIN sites
ON clients.client_id = sites.client_id
WHERE clients.client_id = 10;

/*4. ¿Qué consulta ejecutaría para obtener el número total de sitios 
creados por mes por año para el cliente con una identificación de 1? 
¿Qué pasa con el cliente = 20? REPASAR PORQUE NO LO ENTENDI COMPLETAMENTE*/

SELECT clients.client_id, sites.client_id AS number_of_websites, 
MONTHNAME(created_datetime) AS month_created, YEAR(created_datetime) AS year_created
FROM
clients INNER JOIN sites
ON clients.client_id = sites.client_id
WHERE clients.client_id = 1
GROUP BY sites.site_id;

/*¿Qué pasa con el cliente = 20?*/

SELECT clients.client_id, COUNT(sites.site_id) AS number_of_websites, 
MONTHNAME(created_datetime) AS month_created, YEAR(created_datetime) AS year_created
FROM
clients INNER JOIN sites
ON clients.client_id = sites.client_id
WHERE clients.client_id = 20
GROUP BY sites.site_id;

/*5. ¿Qué consulta ejecutaría para obtener el número total de clientes potenciales
 generados para cada uno de los sitios entre el 1 de enero de 2011 y 
 el 15 de febrero de 2011? NO COMPLETO*/
 
SELECT sites.domain_name AS website, COUNT(leads.first_name) AS number_of_leads, 
DATE_FORMAT(sites.created_datetime, '%M %e, %Y') AS date_generated
FROM
leads INNER JOIN sites
ON leads.site_id = sites.site_id
WHERE sites.created_datetime >= '2011-01-01' 
AND sites.created_datetime <= '2011-02-15'
GROUP BY sites.created_datetime

/*6. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes 
y el número total de clientes potenciales que hemos generado para cada uno de 
nuestros clientes entre el 1 de enero de 2011 y el 31 de diciembre de 2011?*/


/*7. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes 
y el número total de clientes potenciales que hemos generado para cada cliente 
cada mes entre los meses 1 y 6 del año 2011?*/

