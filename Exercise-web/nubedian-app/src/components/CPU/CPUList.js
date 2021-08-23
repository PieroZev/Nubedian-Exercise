import React from 'react'
import { Table, Button } from 'react-bootstrap';

const CPUList = props => {

  const { cpus, editarCPU, borrarCPU} = props;

  const listaCPUs = cpus.map((cpu) => {

    var {id, model, brand, clockSpeed, numberOfThreads, numberOfCores, tdp, price, description} = cpu;

    description = "default Socket";

    /*Search for the socket description by cpuId, didn't work
    for(var i=0;i<sockets.size;i++){ 
      if(sockets[i].cpuId == id)
        description = sockets[i].description;
    }*/

    return (
      
      <tr key={id}>
        <td>{id}</td>
        <td>{model}</td>
        <td>{brand}</td>
        <td>{description}</td>
        <td>
          <Button variant="success" className="mr-2" onClick={() => editarCPU(true, cpu)}> See Details and Edit </Button>
          <Button variant="danger" onClick={()=>borrarCPU(id)}> Delete </Button>
        </td>
      </tr>
      
    )
  });

  return (
    <Table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Model</th>
          <th>Brand</th>
          <th>Socket</th>
        </tr>
      </thead>
      <tbody >
        {listaCPUs}
        </tbody>
    </Table>
  );
  
}

export default CPUList;

