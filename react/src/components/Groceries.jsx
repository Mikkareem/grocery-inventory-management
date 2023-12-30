import React, { useEffect, useState, useCallback } from 'react';
import AddGrocery from './AddGrocery';

const Groceries = () => {

    const [groceries, setGroceries] = useState([]);
    const [error, setError] = useState("")

    const fetchData = () => {
        async function loadGroceries() {
            try {
                const response = await fetch("http://localhost:8080/groceries")
                const groceries = await response.json();
                setGroceries(groceries)
            } catch (error) {
                if(error instanceof Error) {
                    setError(error.message)
                }
            }
        }
        loadGroceries();
    }

    useEffect(() => {
        fetchData();
    }, []);

    const handleSubmit = useCallback((name, count) => {
        let requestHeaders = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ name, count })
        }
        fetch("http://localhost:8080/groceries", requestHeaders).then(() => fetchData());
    }, [])

    return (
        <>
            {
                !!error 
                ? <p>{error}</p> 
                : (<>
                    <AddGrocery handleSubmit={handleSubmit}/> 
                    {groceries.map((grocery) => (<p key={grocery.id} className="grocery-detail">{grocery.name} - {grocery.count}</p>))}
                </>)
            }
        </>
    )
}

export default Groceries;