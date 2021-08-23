import React, {  useState, useEffect } from 'react'
import API from '../../services/API';
import { Button } from 'react-bootstrap';
import SocketList from '../../components/Socket/SocketList';

const Socket = props => {

  const [sockets,setSockets] = useState([]);
  const [socket, setSocketById] = useState([]);

  const [showModal,setShowModal] = useState(false);
  const [isEdit,setIsEdit] = useState(false);
  const [validateForm, setValidateForm] = useState(false);
  const [errorMsg,setErrorMsg] = useState('');

  const initialSocketData = { 
    socketId: 0,
    description: '',
    cpu: 0
  };

  const [newSocketData,setNewSocketData] = useState(initialSocketData); 

  useEffect(() => {
    getSockets();
  }, []);

  const getSockets = async() => {
    try{
      let sockets = await API.get('/sockets');

      setSockets(sockets);
    }
    catch(error){
      console.log(error);
    }
  }

  const getSocketById = async(id)=>{
    try{
      let socket = await API.get(`/sockets/cpu/${id}`);

      setSocketById(socket);

    }
    catch(error){
      console.log(error);
    }
  }

  return (
    <div className="container mt-4 mr-auto">
      <h1>Sockets</h1>
      <SocketList 
        sockets={sockets}
      />
    </div>
  );
  
}

export default Socket;

