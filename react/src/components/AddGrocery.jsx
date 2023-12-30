import React from 'react'

const AddGrocery = (props) => {

    const [name, setName] = React.useState("")
    const [count, setCount] = React.useState(0)

    return (
        <>
            <input placeholder="Enter grocery name" value={name} onChange={(e) => setName(e.target.value)}/>
            <label>Count</label>
            <input type='number' value={count} onChange={(e) => setCount(e.target.value)}/>
            <button onClick={() => props.handleSubmit(name, count)}>Submit</button>
        </>
    )
}

export default AddGrocery