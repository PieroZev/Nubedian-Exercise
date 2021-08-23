import React from 'react'
import { Route, Switch } from 'react-router-dom';
import CPU from '../containers/CPU/CPU';
import Socket from '../containers/Socket/Socket';

export default function Routes() {
  
  return (
    <Switch>
      <Route path="/cpus" component={CPU} exact />
      <Route path="/sockets" component={Socket} exact />
    </Switch>
  )
}
