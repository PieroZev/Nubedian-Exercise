import React, {  useState, useEffect } from 'react'
import API from '../../services/API';
import { Button } from 'react-bootstrap';
import CPUList from '../../components/CPU/CPUList';
import CPUModal from '../../components/CPU/CPUModal';

const CPU = props => {

  const [cpus,setCPUs] = useState([]);
  const [sockets,setSockets] = useState([]);

  const [showModal,setShowModal] = useState(false);
  const [isEdit,setIsEdit] = useState(false);
  const [validateForm, setValidateForm] = useState(false);
  const [errorMsg,setErrorMsg] = useState('');

  const initialCPUData = { 
    model: '',
    brand: '',
    sockets: {
      socketId: 0,
      description: '',
      cpuId: 0
    },
    clockSpeed: 0.00,
    numberOfCores: 0,
    numberOfThreads: 0,
    tdp: 0.00,
    price: 0.00
  };

  const [newCPUData,setNewCPUData] = useState(initialCPUData); 

  useEffect(() => {
    getCPUs();
  }, []);

  const getCPUs = async() => {
    try{
      let cpus = await API.get('/cpus');

      setCPUs(cpus);
    }
    catch(error){
      console.log(error);
    }
  }

  const getSockets = async()=>{
    try{
      let socketsArray = await API.get('/sockets');

      setSockets(socketsArray);

      return socketsArray;
    }
    catch(error){
      console.log(error);
    }
  }
  const borrarCPU = async(id) => {
    if (window.confirm("Are you sure?")) {
      try{
        await API.remove(`/cpus/${id}`);
        getCPUs();
      }
      catch(error){
        console.log(error);
      }
    }
  }

  const agregarCPU = async() => {
    try{
      await API.save('/cpus', newCPUData);
      resetModal();
      getCPUs();
    }
    catch(error){
      setErrorMsg(JSON.stringify(error));
    }
  }

  const editarCPU = async(id) => {
    try{
      await API.update(`/cpus/${id}`, newCPUData);
      resetModal();
      getCPUs();
    }
    catch(error){
      setErrorMsg(JSON.stringify(error));
    }
  }

  const handleFormChange = (tipo,value) => {
    if(value === '')
      setValidateForm(true);

    setNewCPUData({...newCPUData, [tipo]:value});
  }  

  const handleFormSubmit = (form, isEdit) => {
    setValidateForm(true);

    if(form.checkValidity())
      isEdit ? editarCPU(newCPUData.id) : agregarCPU();
  };
 
  const resetModal = () =>{
    setShowModal(false);
    setIsEdit(false);
    setNewCPUData(initialCPUData);
    setValidateForm(false);
    setErrorMsg('');
  }

  const handleOpenModal = (editar = false, CPUToEdit = null) =>{
    if(editar)
    {
      setIsEdit(true);
      setNewCPUData(CPUToEdit);
    }
    setShowModal(true);
  }

  const handleCloseModal = () =>{
    resetModal();
  }

  return (
    <div className="container mt-4 mr-auto">
      <h1>CPUs</h1>
      <Button variant="info mb-3" onClick={()=> handleOpenModal()}>Add CPU</Button> 
      <CPUModal
        show={showModal}
        handleClose={handleCloseModal}
        handleChange={handleFormChange}
        handleSubmit={handleFormSubmit}
        isEdit={isEdit}
        validate={validateForm}
        errorMsg={errorMsg}
        cpu={newCPUData}
      />
      <CPUList
        sockets={sockets}
        cpus={cpus}
        borrarCPU={borrarCPU}
        editarCPU={handleOpenModal}
      />
    </div>
  );
  
}

export default CPU;

