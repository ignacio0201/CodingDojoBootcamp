/*1. ¿Qué consulta ejecutaría para obtener los ingresos totales 
para marzo de 2012? ok*/

SELECT 
    MONTHNAME(billing.charged_datetime) AS month,
    SUM(billing.amount) AS revenue
FROM
    billing
WHERE
    YEAR(charged_datetime) = 2012
        AND MONTH(billing.charged_datetime) = 3
GROUP BY month;

/*2. ¿Qué consulta ejecutaría para obtener los ingresos totales 
recaudados del cliente con una identificación de 2? ok*/

SELECT 
    clients.client_id,
    SUM(billing.amount) AS total_revenue
FROM
    clients
        INNER JOIN
    billing ON clients.client_id = billing.client_id
WHERE
    clients.client_id = 2
GROUP BY clients.client_id;

/*3. ¿Qué consulta ejecutaría para obtener todos los sitios que 
posee client = 10? ok*/

SELECT 
    sites.domain_name AS website, 
    clients.client_id
FROM
    clients
        INNER JOIN
    sites ON clients.client_id = sites.client_id
WHERE
    clients.client_id = 10;

/*4. ¿Qué consulta ejecutaría para obtener el número total de sitios 
creados por mes por año para el cliente con una identificación de 1?
¿Qué pasa con el cliente = 20? ok*/

SELECT 
    clients.client_id,
    COUNT(sites.domain_name) AS number_of_websites,
    MONTHNAME(sites.created_datetime) AS month_created,
    YEAR(sites.created_datetime) AS year_created
FROM
    clients
        INNER JOIN
    sites ON clients.client_id = sites.client_id
WHERE clients.client_id = 1
GROUP BY sites.created_datetime, YEAR(sites.created_datetime);

/*¿Qué pasa con el cliente = 20? ok*/
SELECT 
    clients.client_id,
    COUNT(sites.domain_name) AS number_of_websites,
    MONTHNAME(sites.created_datetime) AS month_created,
    YEAR(sites.created_datetime) AS year_created
FROM
    clients
        INNER JOIN
    sites ON clients.client_id = sites.client_id
WHERE
    clients.client_id = 20
GROUP BY sites.created_datetime , YEAR(sites.created_datetime);


/*5. ¿Qué consulta ejecutaría para obtener el número total de clientes potenciales
 generados para cada uno de los sitios entre el 1 de enero de 2011 y 
 el 15 de febrero de 2011? ok*/
 
SELECT 
    sites.domain_name AS website,
    COUNT(leads.leads_id) AS number_of_leads,
    DATE_FORMAT(leads.registered_datetime, '%M %d, %Y') AS date_generated
FROM
    sites
        INNER JOIN
    leads ON sites.site_id = leads.site_id
WHERE
    leads.registered_datetime >= '2011/01/01'
        AND leads.registered_datetime <= '2011/02/15'
GROUP BY sites.domain_name , leads.registered_datetime;

/*6. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes 
y el número total de clientes potenciales que hemos generado para cada uno de 
nuestros clientes entre el 1 de enero de 2011 y el 31 de diciembre de 2011? ok*/

SELECT 
    CONCAT(clients.first_name, clients.last_name) AS client_name,
    COUNT(leads.leads_id) AS number_of_leads
FROM
    clients
        INNER JOIN
    sites ON clients.client_id = sites.client_id
        INNER JOIN
    leads ON leads.site_id = sites.site_id
WHERE
    leads.registered_datetime >= '2011-01-01'
        AND leads.registered_datetime <= '2011-12-31'
GROUP BY clients.client_id
ORDER BY number_of_leads DESC;
    
/*7. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes
y el número total de clientes potenciales que hemos generado para cada cliente 
cada mes entre los meses 1 y 6 del año 2011? ok*/

SELECT 
    CONCAT(clients.first_name,
            ' ',
            clients.last_name) AS client_name,
    COUNT(leads.leads_id) AS number_of_leads,
    MONTHNAME(leads.registered_datetime) AS month_generated
FROM
    clients
        JOIN
    sites ON clients.client_id = sites.client_id
        JOIN
    leads ON sites.site_id = leads.site_id
WHERE
    leads.registered_datetime >= '2011-01-01'
        AND leads.registered_datetime < '2011-07-01'
GROUP BY clients.client_id , MONTH(leads.registered_datetime)
ORDER BY number_of_leads DESC;

/*8. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y 
el número total de clientes potenciales que hemos generado para cada uno de 
los sitios de nuestros clientes entre el 1 de enero de 2011 y 
el 31 de diciembre de 2011? Solicite esta consulta por ID de cliente. ok

Presente una segunda consulta que muestre todos los clientes, los nombres del sitio
y el número total de clientes potenciales generados en cada sitio en todo momento. ok*/
 
SELECT 
    CONCAT(clients.first_name, ' ', clients.last_name) AS client_name,
    sites.domain_name AS website,
    COUNT(leads.leads_id) AS number_of_leads,
    DATE_FORMAT(leads.registered_datetime, '%M %d, %Y') AS date_generated
FROM
    clients
		INNER JOIN
    sites ON clients.client_id = sites.client_id
		INNER JOIN
    leads ON sites.site_id = leads.site_id
WHERE
    leads.registered_datetime >= '2011-01-01'
        AND leads.registered_datetime <= '2011-12-31'
GROUP BY sites.site_id
ORDER BY clients.client_id;


SELECT 
    CONCAT(clients.first_name,' ', clients.last_name) AS client_name,
    sites.domain_name AS website,
    COUNT(leads.leads_id) AS number_of_leads
FROM
    clients
		INNER JOIN
    sites ON clients.client_id = sites.client_id
		INNER JOIN
    leads ON sites.site_id = leads.site_id
GROUP BY sites.domain_name , CONCAT(clients.first_name,
        ' ',
        clients.last_name)
ORDER BY clients.client_id;
 
/*9. Escriba una sola consulta que recupere los ingresos totales recaudados de cada 
 cliente para cada mes del año. Pídalo por ID de cliente. ok*/

SELECT 
    CONCAT(clients.first_name,
            ' ',
            clients.last_name) AS client_name,
    SUM(billing.amount) AS Total_Revenue,
    MONTHNAME(billing.charged_datetime) AS month_charge,
    YEAR(billing.charged_datetime) AS year_charge
FROM
    clients
        INNER JOIN
    billing ON clients.client_id = billing.client_id
GROUP BY year_charge , month_charge , clients.client_id
ORDER BY clients.client_id ASC , YEAR(billing.charged_datetime) , MONTH(billing.charged_datetime);

/*10. Escriba una sola consulta que recupere todos los sitios que posee cada cliente. 
Agrupe los resultados para que cada fila muestre un nuevo cliente. Se volverá más claro 
cuando agregue un nuevo campo llamado 'sitios' que tiene todos los sitios que posee el cliente. 
(SUGERENCIA: use GROUP_CONCAT) ok*/

SELECT 
    CONCAT(clients.first_name,
            ' ',
            clients.last_name) AS client_name,
    GROUP_CONCAT(sites.domain_name, ' /') AS sites
FROM
    clients
        LEFT JOIN
    sites ON clients.client_id = sites.client_id
GROUP BY clients.client_id;