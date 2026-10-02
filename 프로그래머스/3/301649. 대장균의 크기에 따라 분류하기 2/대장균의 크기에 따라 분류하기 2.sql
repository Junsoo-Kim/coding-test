WITH RANK_CTE AS (
    SELECT
        ID,
        ROW_NUMBER()
            OVER (ORDER BY SIZE_OF_COLONY)
            AS RANKING,
        COUNT(*) 
            OVER ()
            AS CNT
    FROM
        ECOLI_DATA
)

SELECT
    ID,
    CASE
        WHEN RANKING / CNT <= 0.25
            THEN 'LOW'
        WHEN RANKING / CNT <= 0.5
            THEN 'MEDIUM'
        WHEN RANKING / CNT <= 0.75
            THEN 'HIGH'
        ELSE 'CRITICAL'
    END AS COLONY_NAME
FROM
    RANK_CTE
ORDER BY
    ID ASC