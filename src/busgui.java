

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.StageStyle;

public class busgui extends Application {
	int assignCounter=0;


    double remove=0.0;
	int flag=0;
   final tripdb obj=new tripdb();

    public static void main(String[] args) {

        // start(stage);
		launch(args);	
		//account object=new transactions(cardnumberfield.getText(),"0");
		
	}
	
	
	public void start (Stage primarystage) throws Exception{
        //el menu el beykhtar mnha no3 el user
		primarystage.setTitle("Bus Station");
		Label selection = new Label("Select type of user");
		Button manager = new Button("Manager");
		Button driver = new Button ("Driver");
		Button passenger = new Button ("Passenger");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.add(selection, 0, 0);
		grid.add(manager, 0, 2);
		grid.add(driver, 0, 4);
		grid.add(passenger,0, 6);
		 Scene scene = new Scene(grid,600,400);
	       primarystage.setScene(scene);
	       primarystage.show();
	       //law el user kan manager
        manager.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                HashMap<Integer,String> assignedtrips=new HashMap<>();

                manger objm=new manger();

                Stage login = new Stage();
                login.setTitle("Log in");
                Label username = new Label("Username:  ");
                Label password = new Label("password:  ");
                TextField namefield = new TextField();
                TextField passfield = new TextField();
                Button signin = new Button ("Sign in");
                GridPane gridmanager = new GridPane();
                gridmanager.setAlignment(Pos.CENTER);
                gridmanager.add(username,0,0);
                gridmanager.add(namefield, 1, 0);
                gridmanager.add(password, 0, 1);
                gridmanager.add(passfield, 1, 1);
                gridmanager.add(signin, 1, 2);
                Scene loggingm=new Scene (gridmanager,600,400);
                login.setScene(loggingm);
                login.show();
                //bedayt validation el manager
                signin.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        Validate vm = new Validate();
                        boolean testm=vm.valid("manager", namefield.getText(), passfield.getText());
                        if(testm==false) {
                            Stage popupwindow=new Stage();
                            popupwindow.setTitle("ERROR!!");
                            Label invalid= new Label("INVALID USERNAME OR PASSWORD");
                            VBox layout= new VBox(10);
                            layout.getChildren().addAll(invalid);
                            layout.setAlignment(Pos.CENTER);
                            Scene inv= new Scene(layout, 300, 250);
                            popupwindow.setScene(inv);
                            popupwindow.show();

                        }//law katab el info sah haytal3lo el options beta3t el manager
                        else {
                            Stage maprofile= new Stage();

                            maprofile.setTitle("Manager's profile");
                            Button reviewtrips = new Button("Review trips");
                            Button assign= new Button ("Assign trips to drivers");
                            Button delete = new Button ("Delete a trip");
                            Button add = new Button ("Add a trip");
                            GridPane managergrid= new GridPane();
                            managergrid.setAlignment(Pos.CENTER);
                            managergrid.add(reviewtrips, 0, 0);
                            managergrid.add(assign, 0, 1);
                            managergrid.add(delete, 0, 2);
                            managergrid.add(add, 0, 3);
                            Scene loggingm = new Scene(managergrid,600,400);
                            maprofile.setScene(loggingm);
                            maprofile.show();

                            //law el manager ekhtar y review el trip
                            reviewtrips.setOnAction(new EventHandler() {
                                @Override
                                public void handle(Event event)   {
                                    Stage ch = new Stage ();
                                    ch.setTitle("Choose type of trip");
                                    Label cl = new Label("Choose type of trip");
                                    ComboBox<String> choices = new ComboBox<String>();
                                    choices.getItems().add("internal");
                                    choices.getItems().add("external");
                                    Button ok = new Button ("ok");
                                    ListView rt=new ListView();
									GridPane cg = new GridPane ();
                                    cg.setAlignment(Pos.CENTER);
                                    cg.add(cl, 0, 0);
                                    cg.add(choices, 0, 1);
                                    cg.add(ok, 0, 3);
                                    Scene cs = new Scene(cg,400,600);
                                    ch.setScene(cs);
                                    ch.show();

                                ok.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										HashMap<Integer,Trip> x;
										ch.show();
										try {

                                            try {
                                                objm.load(choices.getValue().toString());
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }

                                            if (choices.getValue().toString().equals("internal"))
                                                for (int count : objm.getManagerint().keySet()) {
                                                    rt.getItems().add("by: " + objm.getManagerint().get(count).getVehicle().getVehicleType() + " " +
                                                            "Time: " + objm.getManagerint().get(count).getTripTime() + " From: " + objm.getManagerint().get(count).getSource() + " To: "
                                                            + objm.getManagerint().get(count).getDestination() + " no. of stops: " + objm.getManagerint().get(count).getNo_of_stops());
                                                }
                                            else if (choices.getValue().toString().equals("external")) {
                                                for (int count : objm.getManagerext().keySet()) {
                                                    rt.getItems().add("by: " + objm.getManagerext().get(count).getVehicle().getVehicleType() + " " +
                                                            "Time: " + objm.getManagerext().get(count).getTripTime() + " From: " + objm.getManagerext().get(count).getSource() + " To: "
                                                            + objm.getManagerext().get(count).getDestination() + " no. of stops: " + objm.getManagerext().get(count).getNo_of_stops());
                                                }
                                            }
                                            Stage rev=new Stage();
                                            GridPane cg = new GridPane ();
                                            cg.setAlignment(Pos.CENTER);
                                            cg.add(rt,0,0);
                                            Scene scene=new Scene(cg);
                                            rev.setScene(scene);
                                            rev.show();
                                        }catch (Exception e){

                                        }

									}
								});
                                }

                            });//akher zorar el review
                            // law el manager ekhtar eno y add trip
                            add.setOnAction(new EventHandler() {

                                @Override
                                public void handle(Event event) {
                                    Stage adding = new Stage ();
                                    adding.setTitle("adding");
                                    Label type = new Label("Choose Type of trip you want to add :");
                                    ComboBox<String> typechoice = new ComboBox<>();
                                    typechoice.getItems().add("internal");
                                    typechoice.getItems().add("external");
                                    Label Vehicle = new Label("The vehicle : ");
                                    ComboBox<String> typeVehicle = new ComboBox<String>();
                                    typeVehicle.getItems().add("limousine");
                                    typeVehicle.getItems().add("minibus");
                                    typeVehicle.getItems().add("bus");
                                    Label time = new Label("Trip time : hh:mm-am/pm");
                                    TextField timefield = new TextField();
                                    Label source = new Label ("Trip source : ");
                                    TextField sourcefield = new TextField ();
                                    Label destination = new Label ("Trip destination : ");
                                    TextField destinationField = new TextField ();
                                    Label numberofstops = new Label ("Number of stops : ");
                                    ComboBox<String> choosestops = new ComboBox<String>();
                                    choosestops.getItems().add("nonstop");
                                    choosestops.getItems().add("onestop");
                                    choosestops.getItems().add("manystops");
                                    Button a = new Button("Add trip");
                                    GridPane addg = new GridPane();
                                    addg.setAlignment(Pos.CENTER);
                                    addg.add(type, 0, 0);
                                    addg.add(typechoice, 0, 1);
                                    addg.add(Vehicle, 0, 2);
                                    addg.add(typeVehicle, 0, 3);
                                    addg.add(time, 0, 4);
                                    addg.add(timefield, 0, 5);
                                    addg.add(source, 0, 6);
                                    addg.add(sourcefield, 0, 7);
                                    addg.add(destination, 0, 8);
                                    addg.add(destinationField, 0, 9);
                                    addg.add(numberofstops, 0, 10);
                                    addg.add(choosestops, 0, 11);
                                    addg.add(a, 0, 12);
                                    Scene adder = new Scene(addg,400,600);
                                    adding.setScene(adder);
                                    adding.show();
                                    //keda el user dakhal kol el details
                                    a.setOnAction(new EventHandler() {

                                        @Override
                                        public void handle(Event event) {
                                            Label note = new Label();

                                            try {

                                                try {
                                                    objm.addTrip(typechoice.getValue().toString(), typeVehicle.getValue().toString(), timefield.getText(), sourcefield.getText(), destinationField.getText(), choosestops.getValue().toString());
                                                } catch (IOException e) {
                                                    // TODO Auto-generated catch block
                                                    e.printStackTrace();
                                                }
                                                note.setText("Trip added Successfully");
                                            }catch (Exception e){
                                                note.setText("Error adding trip");
                                            }
                                            addg.add(note, 0, 13);
                                            adding.show();
                                        }

                                    });//keda el trip added khalas

                                }

                            });//nehayt zorar el add


                            //law ekhtar eno y delete a trip

                            delete.setOnAction(new EventHandler() {

                                @Override
                                public void handle(Event event) {
                                    // Person objm = new manger();
                                    Stage deleting = new Stage();
                                    delete.setText("Deleting Trip");
                                    Label choosetype = new Label("Choose trip type");
                                    ComboBox<String> types = new ComboBox<String>();
                                    types.getItems().add("internal");
                                    types.getItems().add("external");
                                    Button ok = new Button ("OK");
                                    GridPane deletegrid = new GridPane();
                                    deletegrid.setAlignment(Pos.CENTER);
                                    deletegrid.add(choosetype,0,0);
                                    deletegrid.add(types, 0, 1);
                                    deletegrid.add(ok, 0, 2);
                                    Scene delete = new Scene(deletegrid,600,400);
                                    deleting.setScene(delete);
                                    deleting.show();
                                    //howa keda ekhtar el type of trip el 3ayez ye3mlha delete
                                    ok.setOnAction(new EventHandler() {

                                        @Override
                                        public void handle(Event event) {
                                            try {
                                                objm.load(types.getValue().toString());
                                            } catch (IOException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                            }
                                            Stage cancel = new Stage();
                                            cancel.setTitle("deleting");
                                            ListView showing = new ListView();
                                            Label choosing = new Label(" Choose index of the trip you want to delete: ");
                                            TextField choose = new TextField ();
                                            Button d = new Button("delete");
											if(types.getValue().toString().equals("internal"))
												for(int count:objm.getManagerint().keySet()){
													showing.getItems().add("by: "+ objm.getManagerint().get(count).getVehicle().getVehicleType()+ " "+
															"Time: " + objm.getManagerint().get(count).getTripTime()+" From: "+objm.getManagerint().get(count).getSource()+" To: "
															+objm.getManagerint().get(count).getDestination()+" no. of stops: "+ objm.getManagerint().get(count).getNo_of_stops()  + " , index: " + count);
												}
											else if(types.getValue().toString().equals("external")){
												for(int count:objm.getManagerext().keySet()) {
													showing.getItems().add("by: " + objm.getManagerext().get(count).getVehicle().getVehicleType() + " " +
															"Time: " + objm.getManagerext().get(count).getTripTime() + " From: " + objm.getManagerext().get(count).getSource() + " To: "
															+ objm.getManagerext().get(count).getDestination() + " no. of stops: " + objm.getManagerext().get(count).getNo_of_stops() + " , index: " + count);
												}
											}
                                            GridPane showg = new GridPane();
                                            showg.add(showing, 0, 0);
                                            showg.add(choosing, 0, 1);
                                            showg.add(choose, 1, 1);
                                            showg.add(d, 0, 2);
                                            Scene st = new Scene (showg);
                                            cancel.setScene(st);
                                            cancel.show();

                                            //keda ekhtar el index beta3 el trip el 3ayez ye3mlha delete
                                            d.setOnAction(new EventHandler() {

                                                @Override
                                                public void handle(Event event) {
                                                    int y=0;
                                                    Label note = new Label();
                                                        try {
                                                            y=Integer.parseInt(choose.getText());
                                                            try {
                                                                int x = objm.CancelTrip(types.getValue().toString(), y);
                                                                if (x == 0)
                                                                    note.setText("Error deleting trip");
                                                                else
                                                                    note.setText("Trip is deleted");

                                                            } catch (IOException e) {
                                                                note.setText(e.getMessage());
                                                                // note.setText("Error deleting trip");
                                                            }
                                                        }catch(Exception e){
                                                            note.setText("No such index!");
                                                        }
                                                    showg.add(note, 0, 3);
                                                    cancel.show();
                                                }


                                            });//trip deleted khalas


                                        }//nehayt eno yekhtar el type of trip



                                    });//nehayt eno yekhtar el type of trip


                                }//nehayt zorar el delete

                            });//nehayt zorar el delete
							assign.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									ComboBox<String> t_type=new ComboBox<>();
									Label tt=new Label("Enter Trip Type");
									Button enter=new Button("Enter");
									t_type.getItems().add("internal");
									t_type.getItems().add("external");
									TextField driverName=new TextField();
									Label ind=new Label("enter index");
									Label info=new Label("enter driver's name ");
									Button done=new Button("Assign Trip");
									TextField assignIndex=new TextField();
									Validate driveVal=new Validate();
									try {
										driveVal.load("driver");
									}
									catch (IOException e){
										e.printStackTrace();
									}
									GridPane one=new GridPane();
									one.setAlignment(Pos.CENTER);
									one.addColumn(0,tt,t_type,enter);
									Scene s1=new Scene(one,600,400);
									Stage stage1=new Stage();
									stage1.setScene(s1);
									stage1.show();
									enter.setOnAction(new EventHandler<ActionEvent>() {
										@Override
										public void handle(ActionEvent event) {
                                            ListView drivers=new ListView();
                                            ListView trips=new ListView();
                                            try {
                                                objm.load(t_type.getValue().toString());
                                            }
                                            catch (IOException e){
                                                e.printStackTrace();
                                            }
											if(t_type.getValue().equals("internal")){
												for(int i:objm.getManagerint().keySet()){
													trips.getItems().add("by: "+objm.getManagerint().get(i).getVehicle().getVehicleType()+
															" Date: "+ objm.getManagerint().get(i).getTripTime() + " From: "+
															objm.getManagerint().get(i).getSource() + " To: "+objm.getManagerint().get(i).getDestination()+
															" No. of stops: "+ objm.getManagerint().get(i).getNo_of_stops()+ " , index: "+ i);
												}
												}else if(t_type.getValue().toString().equals("external")) {
                                                for (int i : objm.getManagerext().keySet()) {
                                                    trips.getItems().add("by: " + objm.getManagerext().get(i).getVehicle().getVehicleType() +
                                                            " Date: " + objm.getManagerext().get(i).getTripTime() + " From: " +
                                                            objm.getManagerext().get(i).getSource() + " To: " + objm.getManagerext().get(i).getDestination() +
                                                            " No. of stops: " + objm.getManagerext().get(i).getNo_of_stops()+ " , index: "+ i);
                                                }

                                            }
                                            for(Driver x:driveVal.getDriver()){
                                                drivers.getItems().add(x.getUsername());
                                            }
                                            GridPane g2=new GridPane();
                                            Label gap=new Label("        ");
                                            Label show=new Label();
                                            g2.setAlignment(Pos.CENTER);
                                            g2.addRow(0,drivers,gap,trips);
                                            g2.addRow(2,assignIndex,ind);
                                            g2.addRow(3,driverName,info);
                                            g2.addRow(4,done);
                                            g2.add(show,0,5);
                                            Scene s2=new Scene(g2,600,400);
                                            Stage stage2=new Stage();
                                            stage2.setScene(s2);
                                            stage2.show();
                                            done.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent event) {
                                                        try {
                                                            if(assignIndex.getText().toString().equals(""))
                                                                show.setText("error");
                                                            else {
                                                                if (t_type.getValue().toString().equals("internal")) {
                                                                    objm.assigntrip(driverName.getText().toString(), objm.getManagerint().get(Integer.parseInt(assignIndex.getText().toString())).getVehicle().getVehicleType(),
                                                                            objm.getManagerint().get(Integer.parseInt(assignIndex.getText().toString())).getTripTime(), objm.getManagerint().get(Integer.parseInt(assignIndex.getText().toString())).getSource(),
                                                                            objm.getManagerint().get(Integer.parseInt(assignIndex.getText().toString())).getDestination(), objm.getManagerint().get(Integer.parseInt(assignIndex.getText().toString())).getNo_of_stops());
                                                                    objm.getManagerint().remove(Integer.parseInt(assignIndex.getText().toString()));
                                                                } else if (t_type.getValue().toString().equals("external")) {
                                                                    objm.assigntrip(driverName.getText().toString(), objm.getManagerext().get(Integer.parseInt(assignIndex.getText().toString())).getVehicle().getVehicleType(),
                                                                            objm.getManagerext().get(Integer.parseInt(assignIndex.getText().toString())).getTripTime(), objm.getManagerext().get(Integer.parseInt(assignIndex.getText().toString())).getSource(),
                                                                            objm.getManagerext().get(Integer.parseInt(assignIndex.getText().toString())).getDestination(), objm.getManagerext().get(Integer.parseInt(assignIndex.getText().toString())).getNo_of_stops());
                                                                    objm.getManagerext().remove(Integer.parseInt(assignIndex.getText().toString()));

                                                                }
                                                            }
                                                            } catch(IOException e){
                                                                e.printStackTrace();
                                                            }

                                                        show.setText("Trip assigned to driver: " + driverName.getText().toString());

                                                }
                                            });
										}
									});

								}

							});
                        }//nehayt functions el manager

                    }

                });//nehayt validation el manager


            }

        });//nehayt zorar el manager
	       // law el user kan driver w ekhtar driver mn el menu
	       driver.setOnAction(new EventHandler() {

			@Override
			public void handle(Event event) {
				Stage login=new Stage();
				login.setTitle("Log in");
				Label username = new Label("Username  ");
				Label password=new Label("ID  ");
				TextField namefield =new TextField();
				TextField passfield = new TextField();
				Button signin = new Button("sign in");
				GridPane griddriver = new GridPane();
				griddriver.setAlignment(Pos.CENTER);
				griddriver.add(username, 0, 0);
				griddriver.add(namefield, 1, 0);
				griddriver.add(password, 0, 1);
				griddriver.add(passfield, 1, 1);
				griddriver.add(signin, 1, 2);
				Scene loggingd = new Scene(griddriver,600,400);
				login.setScene(loggingd);
				login.show();
				//bedayt validation el driver
				signin.setOnAction(new EventHandler() {

					@Override
					public void handle(Event event) {
					Validate vd = new Validate();
					try {
						vd.load("driver");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					boolean td=vd.valid("driver",namefield.getText(), passfield.getText());
					if(td==false) {
						Stage popupwindow=new Stage();
						popupwindow.setTitle("ERROR!!");
						Label invalid= new Label("INVALID USERNAME OR PASSWORD");
						VBox layout= new VBox(10);
						layout.getChildren().addAll(invalid);
						layout.setAlignment(Pos.CENTER);
						Scene inv= new Scene(layout, 300, 250);
						popupwindow.setScene(inv);
					    popupwindow.show();
						
					}
					//law el user dakhal el info beta3t el driver sah
					else {
					    Driver driverin=new Driver();
					    driverin.setUsername(namefield.getText().toString());
					    driverin.setPassword(namefield.getText().toString());
						Stage profiledriver = new Stage();
						profiledriver.setTitle("Driver's profile");
						Label nameinfo = new Label("Welcome " + namefield.getText());
						Label showid = new Label("ID : " + passfield.getText());
						Label error =new Label();
						Label salary = new Label ("Salary = 1500 L.E");
						ListView<String> at=new ListView<>();
						Button assignedt = new Button ("Assigned trips");
						GridPane drivergrid= new GridPane();
						drivergrid.setAlignment(Pos.CENTER);
						drivergrid.add(nameinfo, 0, 0);
						drivergrid.add(showid,0,2);
						drivergrid.add(salary,0,4);
						drivergrid.add(assignedt, 0, 6);
						drivergrid.add(error,0,7);
			
					
						Scene driverprofile = new Scene(drivergrid,600,400);
					       profiledriver.setScene(driverprofile);
					       profiledriver.show();
                        assignedt.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                GridPane list=new GridPane();
                                list.setAlignment(Pos.CENTER);
                                try {

                                    try {
                                        int x = driverin.checkassign(namefield.getText().toString());
                                        if (x == 0) {
                                            error.setText("No trips assigned");

                                        } else {
                                            for (int i = 0; i < driverin.getAssignedTrips().size(); i++) {
                                                at.getItems().add(driverin.getAssignedTrips().get(i).getTypev() + " " + driverin.getAssignedTrips().get(i).getTripTime() + " "
                                                        + driverin.getAssignedTrips().get(i).getSource() + " " + driverin.getAssignedTrips().get(i).getDestination() + " "
                                                        + driverin.getAssignedTrips().get(i).getNo_of_stops());
                                            }
                                            list.add(at, 0, 0);
                                            Scene list1 = new Scene(list);
                                            Stage list2 = new Stage();
                                            list2.setScene(list1);
                                            list2.show();
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }catch (Exception e){

                                }

                            }
                        });
						
						
						
					}
						
					}
				
					
					
				}); //nehayt validation el driver
				
			}
	    	   
	       }); //nehayt el user law kan driver
	       
	       //bedyt el user law kan passenger

		passenger.setOnAction(new EventHandler() {


			@Override
			public void handle(Event event) {
                Person objpass= new Passenger();
                try {
					obj.loadtrip();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			Stage login= new Stage();
			login.setTitle("Log in");
			Label username = new Label("Username  ");
			Label password = new Label("Password  ");
			TextField namefield= new TextField();
			TextField passfield = new TextField();
			Button signin = new Button ("Sign in");
			GridPane gridpass = new GridPane();
			gridpass.setAlignment(Pos.CENTER);
			gridpass.add(username,0, 0);
			gridpass.add(namefield,1, 0);
			gridpass.add(password, 0, 1);
			gridpass.add(passfield, 1,1);
			gridpass.add(signin,1, 2);
			 Scene loggingp = new Scene(gridpass,600,400);
		       login.setScene(loggingp);
		       login.show();
		       //bedayt validation el passenger
			signin.setOnAction(new EventHandler() {
				Validate val= new Validate();

				@Override
				public void handle(Event event) {
				
				//	objpass.
					try {
						val.load("passenger");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				boolean testv=(val.valid("passenger",namefield.getText(),passfield.getText()));
				if(testv==false ) {
					Stage popupwindow=new Stage();
					popupwindow.setTitle("ERROR!!");
					Label invalid= new Label("INVALID USERNAME OR PASSWORD");
					VBox layout= new VBox(10);
					layout.getChildren().addAll(invalid);
					layout.setAlignment(Pos.CENTER);
					Scene inv= new Scene(layout, 300, 250);
					popupwindow.setScene(inv);
				    popupwindow.show();
					
				} 
				//law el user dakhal info el passenger sah
				else {

                    Stage profilepass = new Stage();
					profilepass.setTitle("personal profile");
					Label nameinfo = new Label("Welcome " + namefield.getText());
					Label notify= new Label("Always check your notfications to keep up with new changes. ");
					Button notification = new Button ("Notfications");
					Button show= new Button ("Your Trips");
					Button cancel = new Button("Cancel trip");
					Button  book = new Button ("Book Trip");
					Label l=new Label("");
					GridPane ppgrid= new GridPane();
					ppgrid.setAlignment(Pos.CENTER);
					ppgrid.add(nameinfo, 0, 0);
					ppgrid.add(notify,0,2);
					ppgrid.add(notification,0,4);
					ppgrid.add(show, 0, 6);
					ppgrid.add(cancel, 0,8);
					ppgrid.add(book, 0, 10);
					ppgrid.add(l,0,12);
					Scene pprofile = new Scene(ppgrid,600,400);
				       profilepass.setScene(pprofile);
				       profilepass.show();
				       cancel.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                               try {
                                    ListView<String> list=new ListView<>();
                                    TextField ind=new TextField();
                                    TextField type=new TextField();
                                    Button delete=new Button("delete");
                                    Label ent=new Label("Enter index to be deleted");
                                    Label catching=new Label();
                                    Label n=new Label();
                                   if (flag == 1) {
                                       Stage s=new Stage();
                                       GridPane g= new GridPane();
                                       for(int i=0;i<((Passenger) objpass).getHistoryOfTrips().size();i++){
                                           list.getItems().add(((Passenger) objpass).getHistoryOfTrips().get(i).getTypev() + " "+
                                                   ((Passenger) objpass).getHistoryOfTrips().get(i).getTripTime()+" "+((Passenger) objpass).getHistoryOfTrips().get(i).getSource()
                                                   +" "+((Passenger) objpass).getHistoryOfTrips().get(i).getDestination()+" "+((Passenger) objpass).getHistoryOfTrips().get(i).getNo_of_stops() + " index: "+ i);
                                       }
                                       if(((Passenger) objpass).getHistoryOfTrips().isEmpty()==false) {
                                           GridPane d = new GridPane();
                                           d.setAlignment(Pos.CENTER);
                                           d.add(list, 0, 0);
                                           d.addRow(1, ind, ent);
                                           d.add(delete, 0, 2);
                                           d.add(catching, 0, 3);
                                           Scene del = new Scene(d, 600, 400);
                                           Stage deleteshow = new Stage();
                                           deleteshow.setScene(del);
                                           deleteshow.show();
                                       }
                                       else
                                           l.setText("No trips assigned");
                                       delete.setOnAction(new EventHandler<ActionEvent>() {
                                           @Override
                                           public void handle(ActionEvent event) {
                                               try {

                                                   ((Passenger) objpass).cancelTrip(Integer.parseInt(ind.getText().toString()));
                                                    catching.setText("Trip deleted successfully");

                                               }catch (Exception e){
                                                    catching.setText("Please enter correct data!");
                                               }

                                           }
                                       });

                                   } else
                                       l.setText("No trips assigned");
                               }catch (Exception e){
                                   l.setText("No trips assigned");
                               }
                           }
                       });
				       show.setOnAction(new EventHandler<ActionEvent>() {
						   @Override
						   public void handle(ActionEvent event) {
							   Stage review =new Stage();
							   review.setTitle("Show your trips");
							   ListView<String> reviewList=new ListView<>();
							   reviewList.setMaxSize(1000,650);
							   Trip g1=new InternalTrip();
							   Trip g2=new ExternalTrip();
							   for(int i=0;i<((Passenger) objpass).getHistoryOfTrips().size();i++){
							   	if(((Passenger) objpass).getHistoryOfTrips().get(i) instanceof InternalTrip) {
									g1 = (InternalTrip) ((Passenger) objpass).getHistoryOfTrips().get(i);
									reviewList.getItems().add("by : " + g1.getTypev() + " at : " + g1.getTripTime() + " from :" + g1.getSource() + " To: " + g1.getDestination() + " Number of stops: " + g1.getNo_of_stops());
								}else{
									   g2 = (ExternalTrip) ((Passenger) objpass).getHistoryOfTrips().get(i);
									reviewList.getItems().add("by : " + g2.getTypev() + " at : " + g2.getTripTime() + " from :" + g2.getSource() + " To: " + g2.getDestination() + " Number of stops: " + g2.getNo_of_stops());
								   }
							   }
							   GridPane showgrid = new GridPane();
							   showgrid.setAlignment(Pos.CENTER);
							   showgrid.add(reviewList,0,0);
							   Scene showing = new Scene(showgrid);
							   review.setScene(showing);
							   review.show();

						   }
					   });
				       //bedayt law el user ekhtar y book
				    book.setOnAction(new EventHandler () {

						@Override
						public void handle(Event event) {
						    l.setText("");
							Stage booking = new Stage();
							booking.setTitle("Booking Details");
							Label typetrip = new Label("Choose trip type");
							ComboBox<String> triptype = new ComboBox<String>();
							triptype.getItems().add("internal");
							triptype.getItems().add("external");
							Label typev = new Label("Choose vehicle type");
							ComboBox<String> vehicletype = new ComboBox<String>();
							vehicletype.getItems().add("limousine");
							vehicletype.getItems().add("minibus");
							vehicletype.getItems().add("bus");
							Label typet = new Label("Choose ticket type");
							ComboBox<String> tickettype = new ComboBox<String>();
							tickettype.getItems().add("oneway");
							tickettype.getItems().add("round");
							Button ok = new Button ("Ok");
							GridPane bookgrid = new GridPane ();
							bookgrid.setAlignment(Pos.CENTER);
							bookgrid.add(typetrip, 0, 0);
							bookgrid.add(triptype, 0, 1);
							bookgrid.add(typev, 0, 2);
							bookgrid.add(vehicletype, 0, 3);
							bookgrid.add(typet, 0, 4);
							bookgrid.add(tickettype, 0, 5);
							bookgrid.add(ok, 1, 6);
							Scene book = new Scene(bookgrid,600,400);
							booking.setScene(book);
							booking.show();
						    ok.setOnAction(new EventHandler () {
								@Override
								public void handle(Event event) {
								    remove=0;
                                    try {

                                        if (triptype.getValue().toString().equals("internal"))
                                            obj.useint();
                                        else
                                            obj.useext();

                                        Stage trips = new Stage();
                                        trips.setTitle("Trips");
                                        Label choose = new Label("choose your trip:");
                                        ListView<String> listtrips;
                                        Button enter = new Button("Enter index");
                                        TextField index = new TextField();
                                        Button update = new Button("update");
                                        Label inform = new Label();
                                        final int value = 100;
                                        listtrips = new ListView<String>();
                                        for (int i : obj.getDetailsint().keySet()) {
                                            if (obj.getDetailsint().get(i).getVehicle().getVehicleType().equals(vehicletype.getValue().toString()))
                                                listtrips.getItems().add(obj.getDetailsint().get(i).getVehicle().getVehicleType() +
                                                        " " + obj.getDetailsint().get(i).getTripTime() + " " + obj.getDetailsint().get(i).getSource() + " " + obj.getDetailsint()
                                                        .get(i).getDestination() + " " + obj.getDetailsint().get(i).getNo_of_stops() + " , index : " + i);

                                        }
                                        enter.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                try{
                                                if (index.getText().toString().equals("") || Integer.parseInt(index.getText().toString()) > value) {
                                                    inform.setText("No such index!");
                                                } else {

                                                    int x = Integer.parseInt(index.getText().toString());

                                                    if (obj.getDetailsint().containsKey(x)) {
                                                        flag = 1;
                                                        remove += ((Passenger) objpass).booktrip(x, obj, triptype.getValue().toString(), tickettype.getValue().toString());
                                                        inform.setText("Price of trip(s) booked = " + String.valueOf(remove));

                                                    } else {
                                                        inform.setText("trip is not available anymore :(");
                                                        if (remove == 1)
                                                            obj.getDetailsint().remove(Integer.parseInt(index.getText().toString()));

                                                    }


                                                }
                                                }catch (Exception e){
                                                  inform.setText("Please enter data correctly");
                                                }

                                            }
                                        });
                                        listtrips.setMaxSize(650, 250);
                                        GridPane tripgrid = new GridPane();
                                        tripgrid.setAlignment(Pos.CENTER);
                                        tripgrid.add(choose, 0, 0);
                                        tripgrid.add(listtrips, 0, 1);
                                        tripgrid.add(enter, 0, 10);
                                        tripgrid.add(index, 0, 5);
                                        tripgrid.add(inform, 0, 15);
                                        Scene tripss = new Scene(tripgrid, 600, 400);
                                        trips.setScene(tripss);
                                        trips.show();

                                    }catch (Exception e){
                                        Label errors=new Label("Please enter required data correctly!");
                                        GridPane ge=new GridPane();
                                        ge.setAlignment(Pos.CENTER);
                                        ge.add(errors,0,0);
                                        Scene er=new Scene(ge,600,400);
                                        Stage error =new Stage();
                                        error.setScene(er);
                                        error.show();
                                    }

								}
						    	
						    });

							
							
							
						}
				    	
				    });

					notification.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            ListView<String> not=new ListView<>();
                            try {
                                Label say = new Label("Trips deleted by manager");
                                Label by = new Label();
                                Label from = new Label();
                                Label to = new Label();
                                Label time = new Label();
                                Label stops = new Label();
                                try{
                                for(int i=0;i<((Passenger)objpass).notification().size();i++){

                                          not.getItems().add("deleted : " + ((Passenger)objpass).notification().get(i).getTypev() + " " +
                                                  ((Passenger)objpass).notification().get(i).getTripTime() + " " + ((Passenger)objpass).notification().get(i).getSource()
                                                  + " " + ((Passenger)objpass).notification().get(i).getDestination() + " " +
                                                  ((Passenger)objpass).notification().get(i).getNo_of_stops());


                                }
                                }catch (IOException e){
                                }
                                GridPane c=new GridPane();
                                c.setAlignment(Pos.CENTER);
                                c.addColumn(0,say,not);
                                Scene c1=new Scene(c,600,400);
                                Stage c2=new Stage();
                                c2.setScene(c1);
                                c2.show();
                            }catch(Exception e){
                                l.setText("No new Notifications");
                            }
                        }
                    });
					
				}
				
					
					
				}
				
			});//nehayt el validation beta3 el passenger
			
				
			}
			
		});//nehayt el user law kan passenger
		
		
		
	}//nehayt start method
	
}//nehayt el class body
