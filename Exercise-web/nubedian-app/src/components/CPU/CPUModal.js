import React, { useRef } from 'react'
import { Button, Form, Modal } from 'react-bootstrap';
import FormRowInput from '../FormRow/FormRowInput'

const CPUModal = props => {

  const formRef = useRef(null);
  const {show, handleClose, handleChange, handleSubmit, isEdit, validate, errorMsg,cpu} = props;

  return (
    <Modal
      show={show}
      onHide={handleClose}
      backdrop="static" //Si se hace click fuera del modal este no se cerrara
      keyboard={false}  //Si se presiona la tecla ESC tampoco se cierra
    >
      <Modal.Header closeButton>
        <Modal.Title>{isEdit ? 'Edit CPU' : 'Add CPU'}</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form className="Form" noValidate validated={validate} ref={formRef}>

          <FormRowInput
            label={"Model"}
            type={"text"}
            placeholder={"Insert a Model name"}
            value={cpu.model}
            handleChange={handleChange}
            property={"model"}
          />
          <FormRowInput
            label={"Brand"}
            type={"text"}
            placeholder={"Insert a Brand name"}
            value={cpu.brand}
            handleChange={handleChange}
            property={"brand"}
          />
          <FormRowInput
            label={"ClockSpeed"}
            type={"number"}
            placeholder={"Insert a Clockspeed"}
            value={cpu.clockSpeed}
            handleChange={handleChange}
            property={"clockSpeed"}
          />
          <FormRowInput
            label={"NumberOfCores"}
            type={"number"}
            placeholder={"Insert a number of Cores"}
            value={cpu.numberOfCores}
            handleChange={handleChange}
            property={"numberOfCores"}
          />
          <FormRowInput
            label={"NumberOfThreads"}
            type={"number"}
            placeholder={"Insert a number of Threads"}
            value={cpu.numberOfThreads}
            handleChange={handleChange}
            property={"numberOfThreads"}
          />
          <FormRowInput
            label={"TDP"}
            type={"number"}
            placeholder={"Insert a TDP"}
            value={cpu.tdp}
            handleChange={handleChange}
            property={"tdp"}
          />
          <FormRowInput
            label={"Price in EUR"}
            type={"number"}
            placeholder={"Insert a Price"}
            value={cpu.price}
            handleChange={handleChange}
            property={"price"}
          />

          {errorMsg !== '' &&
            <Form.Group className="alert-danger">
              {errorMsg}
            </Form.Group>
          }

        </Form>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="success" onClick={() => handleSubmit(formRef.current, isEdit)}> {isEdit ? 'Edit' : 'Add'} </Button>
        <Button variant="danger" className="ml-2" onClick={()=>handleClose()}> Cancel </Button>
      </Modal.Footer>
    </Modal>
  );
  
}

export default CPUModal;
