import React from 'react'
import { Table, Button } from 'react-bootstrap';

const SocketList = props => {

  const { sockets } = props;

  const listaSockets = sockets.map((socket) => {

    const {socketId, description, cpu} = socket;
    return (
      <tr key={socketId}>
        <td>{socketId}</td>
        <td>{description}</td>
        <td>{cpu}</td>
      </tr>
    )
  });

  return (
    <Table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Description</th>
          <th>CPU ID</th>
        </tr>
      </thead>
      <tbody>
        {listaSockets}
      </tbody>
    </Table>
  );
  
}

export default SocketList;

